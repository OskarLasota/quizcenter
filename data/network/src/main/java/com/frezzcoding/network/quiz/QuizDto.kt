package com.frezzcoding.network.quiz

data class QuizDto(val id: Int, val userId: Int, val statistics: QuizStatsDto, val content: QuizContentDto)
