package com.frezzcoding.core.data.repository

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.AdMapper
import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails
import com.frezzcoding.network.ads.AdDto
import com.frezzcoding.network.SampleData
import com.frezzcoding.network.quiz.QuizDto
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val adMapper: AdMapper
) : HomeRepository {

    override fun getAds(): List<AdDetails> {
        return SampleData.advertisementsSample.mapNotNull(adMapper::apply)
    }

    override fun getQuizzes(): List<QuizDetails> {
        //return SampleData.quizSample
        return emptyList()
    }


}