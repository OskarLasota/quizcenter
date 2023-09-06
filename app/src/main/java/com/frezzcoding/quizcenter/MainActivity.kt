package com.frezzcoding.quizcenter

import android.os.Bundle
import androidx.compose.material.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frezzcoding.core.screens.SetupNavigation
import com.frezzcoding.ui.screens.Screen
import com.frezzcoding.ui.themes.QuizcenterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private val DEFAULT_SCREEN = Screen.HomeFeed.route
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setupNavigationComposable()
        }
    }

    @Composable
    fun setupNavigationComposable() {
        QuizcenterTheme {
            Surface(modifier = Modifier.fillMaxSize(), elevation = 2.dp) {
                SetupNavigation(startDestination = DEFAULT_SCREEN)
            }
        }
    }
}