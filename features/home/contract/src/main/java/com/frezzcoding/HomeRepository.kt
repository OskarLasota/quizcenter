package com.frezzcoding

import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails

interface HomeRepository {
    fun getAds(): List<AdDetails>
    fun getQuizzes(): List<QuizDetails>
}