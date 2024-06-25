package com.frezzcoding.core.mappers

import com.frezzcoding.domain.models.quiz.QuizAnswer
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.domain.models.quiz.QuizQuestion
import com.frezzcoding.network.answers.AnswerDto
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizOwnerDto
import com.google.firebase.firestore.DocumentSnapshot
import javax.inject.Inject

class QuizMapper @Inject constructor() {
    //todo add null handling
    fun apply(quiz: QuizDto, answers: AnswerDto?, owner: QuizOwnerDto?): QuizDetails? {
        if (quiz.id == null) return null
        if (quiz.description == null) return null
        if (quiz.ownerId == null) return null
        if (owner == null) return null

        return QuizDetails(
            id = quiz.id!!,
            description = quiz.description!!,
            content = mapOf(
                QuizQuestion(quiz.question ?: "") to listOf(
                    QuizAnswer(answers?.firstAnswer ?: "", true),
                    QuizAnswer(answers?.secondAnswer ?: "", false),
                    QuizAnswer(answers?.thirdAnswer ?: "", false)
                )
            ),
            owner = QuizOwner(owner?.name ?: "", owner?.userId!!),
            video = null
        )
    }

    //todo unit test
    fun snapshotToQuizDto(snapshot: DocumentSnapshot): QuizDto {
        return QuizDto(
            id = snapshot.id.toInt(),
            description = snapshot.data?.get("description") as? String,
            ownerId = (snapshot.data?.get("ownerId") as? Long)?.toInt(),
            videoUrl = snapshot.data?.get("videoUrl") as? String,
            question = snapshot.data?.get("question") as? String
        )
    }

}