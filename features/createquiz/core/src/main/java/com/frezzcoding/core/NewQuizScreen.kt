package com.frezzcoding.core

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun NewQuizScreen(
    navController: NavController,
    viewModel: CreateQuizViewModel = hiltViewModel(),
) {
    NewQuizContent(viewModel = viewModel)
}