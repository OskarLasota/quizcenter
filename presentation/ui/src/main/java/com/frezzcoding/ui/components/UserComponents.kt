package com.frezzcoding.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun UserAvatar(paddingStart: Dp = 0.dp) {
    // User Avatar
    Box(
        modifier = Modifier
            .padding(top = 5.dp, start = paddingStart)
            .size(40.dp) // Adjust the size as needed
            .clip(shape = CircleShape) // Clip the avatar to a circle shape
    ) {
        AsyncImage(
            contentDescription = null,
            model = "https://loremflickr.com/320/320/dogs"
        )
    }
}