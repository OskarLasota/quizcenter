package com.frezzcoding.network.quiz

data class QuizDto(
    val id: Int?,
    //val statistics: QuizStatsDto?,
    val description: String?,
    val ownerId: Int?,
    val videoUrl: String?
)
