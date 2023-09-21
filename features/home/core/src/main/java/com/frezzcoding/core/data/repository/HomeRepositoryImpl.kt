package com.frezzcoding.core.data.repository

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.AdMapper
import com.frezzcoding.core.domain.QuizMapper
import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails
import com.frezzcoding.network.SampleData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val adMapper: AdMapper,
    private val quizMapper: QuizMapper
) : HomeRepository {

    override fun getAds(): Flow<List<AdDetails>> {
        val mappedData = SampleData.advertisementsSample.mapNotNull(adMapper::apply)
        return flowOf(mappedData)
    }

    override fun getQuizzes(): Flow<List<QuizDetails>> {
        val mappedData = SampleData.quizSample.mapNotNull(quizMapper::apply)
        return flowOf(mappedData)
    }


}