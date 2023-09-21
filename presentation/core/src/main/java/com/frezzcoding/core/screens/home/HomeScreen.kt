package com.frezzcoding.core.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.frezzcoding.HomeUiState
import com.frezzcoding.HomeViewModel
import com.frezzcoding.ui.components.HomeFeed
import com.frezzcoding.ui.screens.Screens
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    val state by homeViewModel.state.collectAsState(initial = HomeUiState())
    val displayList: ImmutableList<Any> = (state.ads + state.quizzes).toImmutableList()
    HomeFeed(items = displayList) { onAdPressed(navController) }
}

fun onAdPressed(navController: NavController) {
    navController.navigate(Screens.HomeFeed.route)
}
