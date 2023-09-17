package com.frezzcoding.core.data.repository

import com.frezzcoding.core.domain.repo.HomeRepository
import com.frezzcoding.network.ads.AdDto
import com.frezzcoding.network.SampleData
import com.frezzcoding.network.quiz.QuizDto
import javax.inject.Inject

//todo sampledata is temporary
class HomeRepositoryImpl @Inject constructor() : HomeRepository {

    override fun getAds(): List<AdDto> {
        return SampleData.advertisementsSample
    }

    override fun getQuizzes(): List<QuizDto> {
        return SampleData.quizSample
    }


}