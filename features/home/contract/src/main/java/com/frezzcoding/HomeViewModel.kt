package com.frezzcoding

import androidx.media3.common.Player
import com.frezzcoding.domain.models.quiz.QuizDetails
import kotlinx.coroutines.flow.StateFlow

interface HomeViewModel {
    val state: StateFlow<HomeUiState>
    val player: Player

    fun playVideo(quiz: QuizDetails?)
}