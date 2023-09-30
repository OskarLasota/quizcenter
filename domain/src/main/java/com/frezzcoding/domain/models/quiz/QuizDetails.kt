package com.frezzcoding.domain.models.quiz

import com.frezzcoding.domain.models.FeedItem

data class QuizDetails(
    val id: Int,
    val description: String,
    val content: Map<QuizQuestion, List<QuizAnswer>>,
    val owner: QuizOwner,
    val video: String? = null
) : FeedItem

data class QuizAnswer(
    val content: String,
    val isCorrect: Boolean
)

data class QuizQuestion(
    val content: String
)

