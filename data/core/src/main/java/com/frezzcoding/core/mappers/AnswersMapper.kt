package com.frezzcoding.core.mappers

import com.frezzcoding.domain.models.answer.AnswerModel
import com.frezzcoding.network.answers.AnswerDto
import com.frezzcoding.network.quiz.QuizDto
import com.google.firebase.firestore.DocumentSnapshot
import javax.inject.Inject

class AnswersMapper @Inject constructor() {

    fun apply(answersModel: AnswerDto): AnswerModel? {
        return AnswerModel(
            answersModel.quizId,
            answersModel.firstAnswer ?: return null,
            answersModel.secondAnswer ?: return null,
            answersModel.thirdAnswer
        )
    }

    fun snapshotToAnswerDto(snapshot: DocumentSnapshot): AnswerDto {
        return AnswerDto(
            quizId = snapshot.id.toInt(),
            firstAnswer = snapshot.data?.get("firstAnswer") as? String,
            secondAnswer = snapshot.data?.get("secondAnswer") as? String,
            thirdAnswer = snapshot.data?.get("thirdAnswer") as? String,
        )
    }

}