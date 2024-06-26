package com.frezzcoding.core.mappers

import com.frezzcoding.core.firebase.DESCRIPTION
import com.frezzcoding.core.firebase.OWNER_ID
import com.frezzcoding.core.firebase.QUESTION
import com.frezzcoding.core.firebase.VIDEO_URL
import com.frezzcoding.domain.models.quiz.QuizAnswer
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.domain.models.quiz.QuizQuestion
import com.frezzcoding.infrastructure.handleNullString
import com.frezzcoding.network.answers.AnswerDto
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizOwnerDto
import com.google.firebase.firestore.DocumentSnapshot
import javax.inject.Inject

class QuizMapper @Inject constructor() {

    fun apply(quiz: QuizDto, answers: AnswerDto?, owner: QuizOwnerDto?): QuizDetails? {
        if (quiz.id == null) return null
        if (quiz.description == null) return null
        if (quiz.ownerId == null) return null
        if (owner == null) return null
        if (owner.userId == null) return null

        return QuizDetails(
            id = quiz.id!!,
            description = quiz.description!!,
            content = mapOf(
                QuizQuestion(quiz.question.handleNullString(TAG_Q)) to listOf(
                    QuizAnswer(answers?.firstAnswer.handleNullString(TAG_FIRST), true),
                    QuizAnswer(answers?.secondAnswer.handleNullString(TAG_SECOND), false),
                    QuizAnswer(answers?.thirdAnswer.handleNullString(TAG_THIRD), false)
                )
            ),
            owner = QuizOwner(owner.name.handleNullString(TAG_NAME), owner.userId!!),
            video = null
        )
    }

    fun snapshotToQuizDto(snapshot: DocumentSnapshot): QuizDto {
        return QuizDto(
            id = snapshot.id.toInt(),
            description = snapshot.data?.get(DESCRIPTION) as? String,
            ownerId = (snapshot.data?.get(OWNER_ID) as? Long)?.toInt(),
            videoUrl = snapshot.data?.get(VIDEO_URL) as? String,
            question = snapshot.data?.get(QUESTION) as? String
        )
    }

    private companion object {
        const val TAG_Q = "quiz question"
        const val TAG_FIRST = "first answer"
        const val TAG_SECOND = "second answer"
        const val TAG_THIRD = "third answer"
        const val TAG_NAME = "name"
    }

}