package com.example.ucrparkingproject
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
            composable("home") { HomeScreen() }
            composable("profi") { ProfileScreen() }
            composable("settings") { SettingsScreen() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("home") },
            label = { Text("Home") },
            icon = { Icon(Icons.Default.Home, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("profile") },
            label = { Text("Profile") },
            icon = { Icon(Icons.Default.Person, contentDescription = null) }
        )
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate("settings") },
            label = { Text("Settings") },
            icon = { Icon(Icons.Default.Settings, contentDescription = null) }
        )
    }
}

@Composable
fun HomeScreen() { Text("Home") }

@Composable
fun ProfileScreen() { Text("Profile") }

@Composable
fun SettingsScreen() { Text("Settings") }