package com.frezzcoding.core.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import com.frezzcoding.HomeUiState
import com.frezzcoding.HomeViewModel
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.ui.components.HomeFeed
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    homeViewModel.getFeed()
    val state by homeViewModel.state.collectAsState(initial = HomeUiState())
    val displayList: ImmutableList<Any> = (state.ads + state.quizzes).toImmutableList()

    HomeFeed(
        items = displayList,
        player = homeViewModel.player,
        onVideoItemFullyVisible = { item ->
            onVideoItemFullyVisible(item, homeViewModel)
        },
        onItemPressed = { onAdPressed(navController, homeViewModel) }
    )

    homeViewModel.playVideo(null)
}

fun onVideoItemFullyVisible(item: QuizDetails?, viewModel: HomeViewModel) {
    when (item) {
        is QuizDetails -> {
            Log.e("home screen", "quiz video ready to play")
            viewModel.playVideo(item)
        }

        else -> {}
    }
}

fun onAdPressed(navController: NavController, homeViewModel: HomeViewModel) {

}
