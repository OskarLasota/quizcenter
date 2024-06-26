package com.frezzcoding.ui.components.newquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.ui.PlayerView
import com.example.media.MediaPlayerManager
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.ui.components.UserAvatar

@Composable
fun QuizItem(
    quiz: QuizDetails,
    onPressed: () -> Unit,
    player: MediaPlayerManager,
    //lifecycle: Lifecycle.Event
) {
    Row(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        UserAvatar()
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            NameAndUsername(quiz)
            Spacer(modifier = Modifier.size(1.dp))
            FeedContent(quiz, player, onPressed)
            Spacer(modifier = Modifier.size(10.dp))
            QuizActions(quiz)
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
            text = "@${quiz.owner.name}",
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            maxLines = 1,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
    }
}

@Composable
fun FeedContent(
    quiz: QuizDetails,
    player: MediaPlayerManager,
    //lifecycle: Lifecycle.Event,
    onPressed: () -> Unit
) {
    Box {
        Text(
            text = quiz.description,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
    }
    if (quiz.video != null) {
        Box {
            VideoPlayerItem(quiz, player)
        }
    }
}

@Composable
fun VideoPlayerItem(quiz: QuizDetails, player: MediaPlayerManager) {
    AndroidView(
        factory = { context ->
            PlayerView(context).also {
                it.player = player.applyMediaItem(MediaItem.fromUri(quiz.video!!), quiz.id)
            }
        },
        update = {
            //todo this will be necessaryy

//            when (lifecycle) {
//                Lifecycle.Event.ON_PAUSE -> {
//                    it.onPause()
//                    //it.player?.pause()
//                }
//
//                Lifecycle.Event.ON_RESUME -> {
//                    it.onResume()
//                }
//
//                else -> Unit
//            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16 / 9f)
    )
}

@Composable
fun QuizActions(quiz: QuizDetails) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    )
    {
        // Add action buttons here
    }
}