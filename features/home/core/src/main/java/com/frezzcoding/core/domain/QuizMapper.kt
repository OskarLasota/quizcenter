package com.frezzcoding.core.domain

import com.frezzcoding.domain.QuizAnswer
import com.frezzcoding.domain.QuizDetails
import com.frezzcoding.domain.QuizQuestion
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
            }.toMap()
        )
    }

}