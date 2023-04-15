package com.frezzcoding.quizcenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.frezzcoding.core.screens.Screen
import com.frezzcoding.core.screens.SetupNavigation
import com.frezzcoding.quizcenter.presentation.theme.QuizcenterTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    companion object {
        private val DEFAULT_SCREEN = com.frezzcoding.core.screens.Screen.HomeFeed.route
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizcenterTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    com.frezzcoding.core.screens.SetupNavigation(startDestination = DEFAULT_SCREEN)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizcenterTheme {

    }
}