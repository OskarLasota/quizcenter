package com.frezzcoding

import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import java.util.Collections.emptyList

data class HomeUiState(
    val ads: List<AdDetails> = emptyList(),
    val quizzes: List<QuizDetails> = emptyList()
)