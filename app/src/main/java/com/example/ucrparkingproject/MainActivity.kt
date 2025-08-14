package com.example.ucrparkingproject

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ucrparkingproject.ui.theme.UCRParkingProjectTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()



        setContent {
            UCRParkingProjectTheme {
                var showCar by remember { mutableStateOf(true) }

                LaunchedEffect(Unit) {
                    // Wait for loading duration
                    delay(4000)
                    showCar = false
                }

                if (showCar) {
                    LoadingScreen()
                } else {
                    MainNavigation()
                    Greeting(
                        name = "Android",
                        modifier = Modifier
                            .background(Color.Yellow)
                    )
                    LazyColumn { }
                }
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    val context = LocalContext.current
    var showCar by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        val mediaPlayer = MediaPlayer.create(context, R.raw.carengine)
        mediaPlayer.setVolume(1.0f, 1.0f) // Max volume for both left and right channels
        mediaPlayer.start()
        mediaPlayer.setOnCompletionListener { mp -> mp.release() }
        delay(4000) // 6 seconds
        showCar = false
    }

    if (showCar) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.baseline_directions_car_24),
                    contentDescription = "Loading",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(24.dp))
                LinearProgressIndicator(
                    modifier = Modifier.size(width = 140.dp, height = 8.dp)
                )
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello whats good man $name!",
        modifier = modifier

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UCRParkingProjectTheme {
        Greeting("Android")
        Column(
            modifier = Modifier            // start a fresh modifier chain
                .background(Color.Yellow)  // so the area is easy to spot
                .padding(16.dp)            // add 16‑dp space on **all** sides

        ) {
            Text("Item 1")
            Text("Item 2")
        }

    }
}