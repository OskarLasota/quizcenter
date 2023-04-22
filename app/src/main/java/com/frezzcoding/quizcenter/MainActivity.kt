package com.frezzcoding.quizcenter

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
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
            QuizcenterTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SetupNavigation(startDestination = DEFAULT_SCREEN)
                }
            }
        }
    }
}