package com.frezzcoding.network.quiz

data class QuizContentDto(
    val id: Int?,
    val description: String?,
    val content: Map<QuizQuestionDto, List<QuizAnswerDto>>
)

data class QuizAnswerDto(
    val content: String,
    val isCorrect: Boolean
)

data class QuizQuestionDto(
    val content: String
)