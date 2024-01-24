package com.frezzcoding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewQuizComponent(
    onQuizPosted: () -> Unit,
) {
    //top part with X button and Post button
    //mid content part - avatar on left and text box with description
    //mid content part - add quiz answers
    //bottom gallery on top of keyboard
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxHeight()
    ) {
        QuizActionHeader()
    }
}

@Composable
@Preview
fun QuizActionHeader() {
    Row(
        modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "Exit screen", // todo localise
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
        )
        Icon(
            imageVector = Icons.Default.CheckCircle,
            contentDescription = "Submit quiz", // todo localise
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
        )
    }
}