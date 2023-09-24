package com.frezzcoding.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.frezzcoding.domain.QuizDetails

@Composable
fun QuizItem(quiz: QuizDetails, onPressed: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        UserAvatar(quiz)
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            NameAndUsername(quiz)
            Spacer(modifier = Modifier.size(1.dp))
            DescriptionAndImage(quiz)
            Spacer(modifier = Modifier.size(10.dp))
            AdActions(quiz)
        }
    }
}


@Composable
fun NameAndUsername(quiz: QuizDetails) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        Text(
            text = "test name @tester", // todo add this to domain quiz model
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            maxLines = 1,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
    }
}

@Composable
fun UserAvatar(quiz: QuizDetails) {
    // User Avatar
    Box(
        modifier = Modifier
            .padding(top = 5.dp)
            .size(40.dp) // Adjust the size as needed
            .clip(shape = CircleShape) // Clip the avatar to a circle shape
    ) {
        // Can load the user's avatar image here
        AsyncImage(
            contentDescription = null,
            model = "https://loremflickr.com/320/320/dogs"
        )
    }
}

@Composable
fun DescriptionAndImage(quiz: QuizDetails) {
    Box {
        Text(
            text = quiz.description,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun AdActions(quiz: QuizDetails) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    )
    {
        // Add action buttons here
    }
}