package com.frezzcoding.core.data.repository

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.FakeApiService
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.QuizMapper
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiService: FakeApiService,
    private val adMapper: AdMapper,
    private val quizMapper: QuizMapper
) : HomeRepository {

    override fun getAds(): Flow<List<AdDetails>> {
        val mappedData = apiService.fetchAds().mapNotNull(adMapper::apply)
        return flowOf(mappedData)
    }

    override fun getQuizzes(): Flow<List<QuizDetails>> {
        val mappedData = apiService.fetchQuizzes().mapNotNull(quizMapper::apply)
        return flowOf(mappedData)
    }


}