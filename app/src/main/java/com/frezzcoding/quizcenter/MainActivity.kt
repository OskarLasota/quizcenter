package com.frezzcoding.quizcenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.frezzcoding.core.screens.SetupNavigation
import com.frezzcoding.ui.screens.Screens
import com.frezzcoding.ui.themes.QuizcenterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private val DEFAULT_SCREEN = Screens.HomeFeed.route
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainApp()
        }
    }

    @Composable
    fun MainApp() {
        QuizcenterTheme {
            setupNavigationComposable()
        }
    }

    @Composable
    fun setupNavigationComposable() {
        SetupNavigation(startDestination = DEFAULT_SCREEN)
    }
}