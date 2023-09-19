package com.frezzcoding.core.data.repository

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.AdMapper
import com.frezzcoding.core.domain.QuizMapper
import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails
import com.frezzcoding.network.SampleData
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val adMapper: AdMapper,
    private val quizMapper: QuizMapper
) : HomeRepository {

    override fun getAds(): List<AdDetails> {
        return SampleData.advertisementsSample.mapNotNull(adMapper::apply)
    }

    override fun getQuizzes(): List<QuizDetails> {
        return SampleData.quizSample.mapNotNull(quizMapper::apply)
    }


}