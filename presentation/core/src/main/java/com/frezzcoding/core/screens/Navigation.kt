package com.frezzcoding.core.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.frezzcoding.ui.components.BottomBar
import com.frezzcoding.ui.screens.HomeScreen
import com.frezzcoding.ui.screens.Screen


@Composable
fun NavigationGraph(
    navController: NavHostController,
    startDestination: String,
//    scrollState: LazyListState
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable(
            route = Screen.HomeFeed.route
        ) {
            HomeScreen(navController = navController)
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetupNavigation(startDestination: String) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

//    val scrollState = rememberLazyListState()
//    val state by remember { derivedStateOf { scrollState.firstVisibleItemIndex == 0 } }
//
//    Scaffold(bottomBar = {
//        if ((currentRoute == Screen.HomeFeed.route && state)) {
//            Column(
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Box(contentAlignment = Alignment.Center) {
//                    BottomBar(navController = navController)
//                }
//            }
//        }
//    }) {
//        NavigationGraph(
//            navController = navController,
//            startDestination = startDestination,
//            scrollState = scrollState
//        )
//    }
}