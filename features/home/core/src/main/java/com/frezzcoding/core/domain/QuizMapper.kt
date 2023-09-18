package com.frezzcoding.core.domain

import com.frezzcoding.domain.QuizDetails
import com.frezzcoding.network.quiz.QuizDto
import javax.inject.Inject

class QuizMapper @Inject constructor() {

    fun apply(quiz: QuizDto): QuizDetails? {
        return null
    }

}