package com.frezzcoding.core.data.repository

import android.util.Log
import com.frezzcoding.HomeRepository
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.QuizMapper
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.network.quiz.QuizDto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val adMapper: AdMapper,
    private val quizMapper: QuizMapper,
    private val db: FirebaseFirestore // todo create a wrapper
) : HomeRepository {

    override fun getAds(): Flow<List<AdDetails>> {
        //val mappedData = apiService.fetchAds().mapNotNull(adMapper::apply)
        return flow { emit(emptyList()) }
    }

    override fun getQuizzes(uid: Int): Flow<List<QuizDetails>> = flow {
        try {
            val quizzesReference = db.collection("/quizzes").whereEqualTo("ownerId", uid)
            val ownerReference = db.collection("/owner").document(uid.toString())
            val resultTask = quizzesReference.get().await()
            val ownerResultTask = ownerReference.get().await()

            val quizzes: List<QuizDto> = resultTask.documents.map(quizMapper::snapshotToQuizDto)
            val mappedQuizzes: List<QuizDetails> = quizzes.mapNotNull { quizMapper.apply(it) }

            emit(mappedQuizzes)
        } catch (exception: Exception) {
            Log.e("HomeRepositoryImpl", exception.toString())
            emit(emptyList())
        }
    }


}