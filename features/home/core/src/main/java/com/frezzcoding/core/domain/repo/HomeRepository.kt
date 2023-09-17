package com.frezzcoding.core.domain.repo

import com.frezzcoding.network.ads.AdDto
import com.frezzcoding.network.quiz.QuizDto

interface HomeRepository {
    fun getAds(): List<AdDto>
    fun getQuizzes(): List<QuizDto>
}