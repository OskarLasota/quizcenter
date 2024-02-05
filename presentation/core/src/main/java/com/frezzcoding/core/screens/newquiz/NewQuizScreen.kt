package com.frezzcoding.core.screens.newquiz

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.frezzcoding.CreateQuizViewModel
import com.frezzcoding.HomeViewModel
import com.frezzcoding.ui.components.NewQuizComponent

@Composable
fun NewQuizScreen(
    navController: NavController,
    homeViewModel: CreateQuizViewModel
) {
    NewQuizComponent(onQuizPosted = { onNewQuizPosted() }, onQuizClosed = { onQuizClosed() })
}

fun onNewQuizPosted() {
    Log.d("new quiz", "quiz posted")
}

fun onQuizClosed() {
    Log.d("new quiz", "quiz closed")
}