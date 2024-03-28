package com.frezzcoding.core

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NewQuizScreen(
    navController: NavController,
    viewModel: CreateQuizViewModel = hiltViewModel(),
) {
    //todo recompositions caused by navigation, when startNavigation is changed to here, recompositions are not happening
    //todo need to read more on recomposition and how to avoid
    NewQuizContent(
        onQuizPosted = { onNewQuizPosted(navController, viewModel = viewModel)
        },
        onQuizClosed = { //onQuizClosed(navController, createQuizViewModel)
        }
    )
}

fun onNewQuizPosted(navController: NavController,viewModel: CreateQuizViewModel ) {
    println("test")
}

fun onQuizClosed(navController: NavController, createQuizViewModel: CreateQuizViewModel) {
    createQuizViewModel.onQuizScreenClosed()
    navController.popBackStack()
}