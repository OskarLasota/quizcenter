package com.frezzcoding.core.screens

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.frezzcoding.ui.components.HomeFeed
import com.frezzcoding.ui.screens.Screen


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Gray.toArgb()

    val state by homeViewModel.state.collectAsState(initial = HomeUiState())


    HomeFeed(ads = state.list) { onAdPressed(navController) }

}

fun onAdPressed(navController: NavController) {
    navController.navigate(Screen.HomeFeed.route)
}
