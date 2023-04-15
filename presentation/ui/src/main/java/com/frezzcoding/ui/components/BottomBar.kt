package com.frezzcoding.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.frezzcoding.ui.screens.Screen

@Composable
fun BottomBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    BottomNavigation(backgroundColor = Color(Color.LightGray.value)) {
        BottomNavigationItem(icon = {
            Icon(
                imageVector = Icons.Default.AddCircle,
                contentDescription = "Home"
            )
        },
            //selectedContentColor = Color.Black,
            //unselectedContentColor = Color.White,
            alwaysShowLabel = false,
            selected = currentRoute == Screen.HomeFeed.route,
            onClick = {
                navController.navigate(Screen.HomeFeed.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }
        )
    }
}