package com.frezzcoding.domain.models.answer

data class AnswerModel(
    val quizId: Int,
    val firstAnswer: String,
    val secondAnswer: String,
    val thirdAnswer: String?
)