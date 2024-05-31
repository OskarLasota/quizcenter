package com.frezzcoding.network.answers

data class AnswerDto(
    val quizId: Int,
    val firstAnswer: String?,
    val secondAnswer: String?,
    val thirdAnswer: String?
)