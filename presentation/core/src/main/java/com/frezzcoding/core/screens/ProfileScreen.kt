package com.frezzcoding.core.screens

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current as Activity

    context.window.statusBarColor = Color.Blue.toArgb()
}