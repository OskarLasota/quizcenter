package com.frezzcoding

import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getAds(): Flow<List<AdDetails>>
    fun getQuizzes(): Flow<List<QuizDetails>>
}