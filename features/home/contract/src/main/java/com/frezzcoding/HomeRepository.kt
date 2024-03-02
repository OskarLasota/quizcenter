package com.frezzcoding

import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getAds(): Flow<List<AdDetails>>
    fun getQuizzes(uid: Int): Flow<List<QuizDetails>>
}