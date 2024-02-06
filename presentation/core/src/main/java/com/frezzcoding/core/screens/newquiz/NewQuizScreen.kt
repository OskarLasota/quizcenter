package com.frezzcoding.core.screens.newquiz

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.frezzcoding.CreateQuizViewModel
import com.frezzcoding.ui.components.NewQuizComponent

@Composable
fun NewQuizScreen(
    navController: NavController,
    createQuizViewModel: CreateQuizViewModel
) {
    NewQuizComponent(
        onQuizPosted = { onNewQuizPosted(createQuizViewModel) },
        onQuizClosed = { onQuizClosed(navController, createQuizViewModel) })
}

fun onNewQuizPosted(createQuizViewModel: CreateQuizViewModel) {
    createQuizViewModel.onCreateQuizAction()
}

fun onQuizClosed(navController: NavController, createQuizViewModel: CreateQuizViewModel) {
    createQuizViewModel.onQuizScreenClosed()
    navController.popBackStack()
}