package com.frezzcoding

import com.example.media.MediaPlayerManager
import com.frezzcoding.domain.models.quiz.QuizDetails
import kotlinx.coroutines.flow.StateFlow

interface HomeViewModel {
    val state: StateFlow<HomeUiState>
    val player: MediaPlayerManager

    fun getFeed()
    fun playVideo(quiz: QuizDetails?)
}