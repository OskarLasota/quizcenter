package com.frezzcoding.core.data.repository

import android.util.Log
import com.frezzcoding.HomeRepository
import com.frezzcoding.core.firebase.FirestoreWrapper
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.AnswersMapper
import com.frezzcoding.core.mappers.OwnerDetailsMapper
import com.frezzcoding.core.mappers.QuizMapper
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.answer.AnswerModel
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.network.answers.AnswerDto
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizOwnerDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val adMapper: AdMapper,
    private val quizMapper: QuizMapper,
    private val answersMapper: AnswersMapper,
    private val ownerDetailsMapper: OwnerDetailsMapper,
    private val db: FirestoreWrapper
) : HomeRepository {

    override fun getAds(): Flow<List<AdDetails>> {
        return flow { emit(emptyList()) }
    }

    //todo hide uid inside an analytics object to avoid confusion
    override fun getQuizzes(uid: Int): Flow<List<QuizDetails>> = flow {
        try {
            //getQuizzes from firebase
            val quizDocuments = db.getQuizzesCollection(uid)
            val quizzes: List<QuizDto> = quizDocuments.map(quizMapper::snapshotToQuizDto)

            //getAnswers from available quizzes
            val answerDocuments = db.getAnswersCollection(quizzes.mapNotNull { it.id })
            val answers: List<AnswerDto> = answerDocuments?.map(answersMapper::snapshotToAnswerDto) ?: emptyList()

            //getOwners from available quizzes
            val ownerDocuments = db.getOwnerListCollection(quizzes.mapNotNull { it.ownerId })
            val owners: List<QuizOwnerDto> = ownerDocuments?.map(ownerDetailsMapper::snapshotToOwnerDto) ?: emptyList()

            val result = quizzes.map { quiz -> quizMapper.apply(quiz, answers.find { it.quizId == quiz.id}, owners.find { it.userId == quiz.ownerId }) }
            emit(result.filterNotNull())
        } catch (exception: Exception) {
            Log.e("HomeRepositoryImpl", exception.toString())
            emit(emptyList())
        }
    }


}