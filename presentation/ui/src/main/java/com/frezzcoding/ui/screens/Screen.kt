package com.frezzcoding.quizcenter.presentation.utils

sealed class Screen(val route: String) {
    object HomeFeed: Screen(route = "home_feed")
}