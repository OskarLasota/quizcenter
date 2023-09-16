package com.frezzcoding.network.quiz

data class QuizContentDto(
    val id: Int?,
    val description: String?,
    val content: Map<QuizQuestion, List<QuizAnswer>>?
)

data class QuizAnswer(
    val content: String?,
    val isCorrect: Boolean?
)

data class QuizQuestion(
    val content: String?
)