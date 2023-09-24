package com.frezzcoding.core.domain

import com.frezzcoding.domain.models.quiz.QuizAnswer
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.domain.models.quiz.QuizQuestion
import com.frezzcoding.network.quiz.QuizDto
import javax.inject.Inject

class QuizMapper @Inject constructor() {

    fun apply(quiz: QuizDto): QuizDetails? {
        if (quiz.id == null) return null
        if (quiz.userId == null) return null
        if (quiz.content.description == null) return null

        return QuizDetails(
            id = quiz.id!!,
            description = quiz.content.description!!,
            content = quiz.content.content.map { (question, answers) ->
                QuizQuestion(content = question.content) to answers.map {
                    QuizAnswer(
                        content = it.content,
                        isCorrect = it.isCorrect
                    )
                }
            }.toMap(),
            owner = QuizOwner(name = quiz.owner.name) // todo this mapping could probably be an extension?
        )
    }

}