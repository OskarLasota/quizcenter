package com.frezzcoding.domain.models.quiz

data class QuizDetails(
    val id: Int,
    val description: String,
    val content: Map<QuizQuestion, List<QuizAnswer>>,
    val owner: QuizOwner
)

data class QuizAnswer(
    val content: String,
    val isCorrect: Boolean
)

data class QuizQuestion(
    val content: String
)

