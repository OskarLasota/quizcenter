package com.frezzcoding.core.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.frezzcoding.core.NewQuizScreen
import com.frezzcoding.core.screens.account.AccountScreen
import com.frezzcoding.core.screens.home.HomeScreen
import com.frezzcoding.core.screens.search.SearchScreen
import com.frezzcoding.ui.components.BottomNavigationBar
import com.frezzcoding.ui.screens.Screens
import javax.inject.Inject

class AppNavigator @Inject constructor() {

    @Composable
    fun NavigationGraph(
        navController: NavHostController,
        startDestination: String,
    ) {
        NavHost(navController = navController, startDestination = startDestination) {
            composable(route = Screens.HomeFeed.route) {
                HomeScreen(navController = navController)
            }
            composable(route = Screens.NewQuizScreens.route) {
                NewQuizScreen(navController = navController)
            }
            composable(route = Screens.SearchScreens.route) {
                SearchScreen(navController = navController)
            }
            composable(route = Screens.AccountScreen.route) {
                AccountScreen(navController = navController)
            }
        }
    }


    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun SetupNavigation(startDestination: String) {
        val navController = rememberNavController()

        Scaffold(backgroundColor = MaterialTheme.colors.secondary, bottomBar = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(contentAlignment = Alignment.Center) {
                        BottomNavigationBar(navController = navController)
                    }
                }
        }) {
            NavigationGraph(
                navController = navController,
                startDestination = startDestination,
            )
        }
    }

}