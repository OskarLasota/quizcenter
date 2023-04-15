package com.frezzcoding.ui.screens

sealed class Screen(val route: String) {
    object HomeFeed: Screen(route = "home_feed")
}