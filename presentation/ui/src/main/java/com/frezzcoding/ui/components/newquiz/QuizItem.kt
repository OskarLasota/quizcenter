package com.frezzcoding.ui.components.newquiz

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.ui.PlayerView
import com.example.media.MediaPlayerManager
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.ui.components.QuizButton
import com.frezzcoding.ui.components.UserAvatar
import com.frezzcoding.ui.themes.DefaultLight
import com.frezzcoding.ui.themes.Green
import com.frezzcoding.ui.themes.Red

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
            Spacer(modifier = Modifier.size(4.dp))
            QuizAnswers(quiz)
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
    Box {
        Text(
            text = quiz.content.first.content,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .padding(vertical = 8.dp)
        )
    }
    if (quiz.video != null) {
        Box {
            VideoPlayerItem(quiz, player)
        }
    }
}

@Composable
fun QuizAnswers(quiz: QuizDetails) {
    Box {
        Column {
            var quizAnswered by remember { mutableStateOf(false) }
            quiz.content.second.forEach {
                val backgroundColor = when {
                    !quizAnswered -> DefaultLight
                    it.isCorrect -> Green
                    !it.isCorrect -> Red
                    else -> DefaultLight
                }

                QuizButton(
                    content = it.content,
                    backgroundColor = backgroundColor,
                    onClick = {
                        quizAnswered = true
                    }
                )
            }
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