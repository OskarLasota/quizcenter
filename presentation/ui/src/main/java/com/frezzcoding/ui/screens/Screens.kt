package com.frezzcoding.ui.screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.frezzcoding.quizcenter.presentation.ui.R

sealed class Screens(val route: String, @StringRes val titleResId: Int, val icon: ImageVector) {
    object HomeFeed : Screens(
        route = "home_feed",
        titleResId = R.string.home_screen_title,
        icon = Icons.Default.Home
    )

    object NewQuizScreens : Screens(
        route = "new_quiz_screen",
        titleResId = R.string.new_quiz_screen_title,
        icon = Icons.Default.Add
    )

    object SearchScreens : Screens(
        route = "search_screen",
        titleResId = R.string.search_screen_title,
        icon = Icons.Default.Search
    )

    object AccountScreen : Screens(
        route = "account_screen",
        titleResId = R.string.account_screen_title,
        icon = Icons.Default.Person
    )
}