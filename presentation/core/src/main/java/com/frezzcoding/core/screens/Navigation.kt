package com.frezzcoding.core.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.frezzcoding.ui.components.BottomNavigationBar
import com.frezzcoding.ui.screens.Screens


@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String,
    scrollState: LazyListState
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
        composable(route = Screens.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetupNavigation(startDestination: String) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val scrollState = rememberLazyListState()
    val state by remember { derivedStateOf { scrollState.firstVisibleItemIndex == 0 } }

    Scaffold(bottomBar = {
        if ((currentRoute == Screens.HomeFeed.route && state)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(contentAlignment = Alignment.Center) {
                    BottomNavigationBar(navController = navController)
                }
            }
        }
    }) {
        NavigationGraph(
            navController = navController,
            startDestination = startDestination,
            scrollState = scrollState
        )
    }
}