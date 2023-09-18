package com.frezzcoding.core.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.frezzcoding.HomeUiState
import com.frezzcoding.HomeViewModel
import com.frezzcoding.ui.components.HomeFeed
import com.frezzcoding.ui.screens.Screens


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    val state by homeViewModel.state.collectAsState(initial = HomeUiState())
    val displayList: List<Any> = state.ads + state.quizzes
    HomeFeed(items = displayList) { onAdPressed(navController) }
}

fun onAdPressed(navController: NavController) {
    navController.navigate(Screens.HomeFeed.route)
}
