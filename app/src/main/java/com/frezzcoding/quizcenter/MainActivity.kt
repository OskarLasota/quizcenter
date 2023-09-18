package com.frezzcoding.quizcenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.frezzcoding.core.screens.AppNavigator
import com.frezzcoding.ui.screens.Screens
import com.frezzcoding.ui.themes.QuizcenterTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var appNavigator: AppNavigator

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
        appNavigator.SetupNavigation(startDestination = DEFAULT_SCREEN)
    }
}