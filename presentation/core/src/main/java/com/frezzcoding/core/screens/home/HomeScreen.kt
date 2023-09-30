package com.frezzcoding.core.screens.home

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.frezzcoding.HomeUiState
import com.frezzcoding.HomeViewModel
import com.frezzcoding.domain.models.FeedItem
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.ui.components.HomeFeed
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList


@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel
) {
    val state by homeViewModel.state.collectAsState(initial = HomeUiState())
    val displayList: ImmutableList<Any> = (state.ads + state.quizzes).toImmutableList()

    var lifecycle by remember {
        mutableStateOf(Lifecycle.Event.ON_CREATE)
    }

    val lifecycleOwner = LocalLifecycleOwner.current

    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            lifecycle = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    HomeFeed(
        items = displayList,
        player = homeViewModel.player,
        lifecycle = lifecycle,
        onItemFullyVisible = { item ->
            onItemFullyVisible(item)
        },
        onItemPressed = { onAdPressed(navController, homeViewModel) }
    )

    homeViewModel.playVideo(null)
}

fun onItemFullyVisible(item: FeedItem?) {
    when(item) {
        is QuizDetails -> {
            Log.e("home screen", "quiz details visible")
        }
        is AdDetails -> {
            Log.e("home screen", "ad visible")
        }
    }
}

fun onAdPressed(navController: NavController, homeViewModel: HomeViewModel) {}
