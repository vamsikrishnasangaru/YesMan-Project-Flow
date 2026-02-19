package com.yesman.autoride.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yesman.autoride.ui.screens.BookRideScreen
import com.yesman.autoride.ui.screens.HomeScreen
import com.yesman.autoride.ui.screens.ProfileScreen
import com.yesman.autoride.ui.screens.RideStatusScreen

private sealed class AppDestination(val route: String, val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector) {
    data object Home : AppDestination("home", "Home", Icons.Default.Home)
    data object Book : AppDestination("book", "Book", Icons.Default.DirectionsCar)
    data object Profile : AppDestination("profile", "Profile", Icons.Default.Person)
}

@Composable
fun AutoRaidApp() {
    val navController = rememberNavController()
    val tabs = listOf(AppDestination.Home, AppDestination.Book, AppDestination.Profile)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                tabs.forEach { destination ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                        onClick = {
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(destination.icon, contentDescription = destination.label) },
                        label = { Text(destination.label) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(AppDestination.Home.route) {
                HomeScreen(onBookNow = { navController.navigate(AppDestination.Book.route) })
            }
            composable(AppDestination.Book.route) {
                BookRideScreen(onConfirmRide = { navController.navigate("ride_status") })
            }
            composable("ride_status") {
                RideStatusScreen(onBackHome = {
                    navController.popBackStack(AppDestination.Home.route, inclusive = false)
                })
            }
            composable(AppDestination.Profile.route) {
                ProfileScreen()
            }
        }
    }
}
