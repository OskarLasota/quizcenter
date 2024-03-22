package com.frezzcoding.core.data.repository

import android.util.Log
import com.frezzcoding.HomeRepository
import com.frezzcoding.core.firebase.FirestoreWrapper
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.QuizMapper
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.network.quiz.QuizDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val adMapper: AdMapper,
    private val quizMapper: QuizMapper,
    private val db: FirestoreWrapper
) : HomeRepository {

    override fun getAds(): Flow<List<AdDetails>> {
        return flow { emit(emptyList()) }
    }

    override fun getQuizzes(uid: Int): Flow<List<QuizDetails>> = flow {
        try {
            val quizDocuments = db.getQuizzesCollection(uid.toString())

            val quizzes: List<QuizDto> = quizDocuments.map(quizMapper::snapshotToQuizDto)
            val mappedQuizzes: List<QuizDetails> = quizzes.mapNotNull { quizMapper.apply(it) }

            emit(mappedQuizzes)
        } catch (exception: Exception) {
            Log.e("HomeRepositoryImpl", exception.toString())
            emit(emptyList())
        }
    }


}