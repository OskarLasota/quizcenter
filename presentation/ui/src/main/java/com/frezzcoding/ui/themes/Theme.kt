package com.frezzcoding.ui.themes

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColors(
        primary = DefaultGreyish,
        primaryVariant = DefaultLight,
        secondary = DefaultLight
)

private val LightColorPalette = lightColors(
        primary = DefaultGreyish,
        primaryVariant = DefaultLight,
        secondary = DefaultLight
)

@Composable
fun QuizcenterTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val context = LocalContext.current as Activity
    context.window.statusBarColor = DefaultGreyish.toArgb()
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
    )
}