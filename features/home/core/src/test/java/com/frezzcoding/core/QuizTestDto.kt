package com.frezzcoding.core

import com.frezzcoding.domain.models.quiz.QuizAnswer
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.domain.models.quiz.QuizQuestion
import com.frezzcoding.network.quiz.QuizAnswerDto
import com.frezzcoding.network.quiz.QuizContentDto
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizOwnerDto
import com.frezzcoding.network.quiz.QuizQuestionDto
import com.frezzcoding.network.quiz.QuizStatsDto

val correctQuizDto = QuizDto(
    id = 123,
    userId = 123,
    statistics = correctQuizStatsDto,
    content = correctQuizContentDto,
    owner = correctQuizOwnerDto
)

val correctQuizModel = QuizDetails(
    id = 123,
    description = "desc",
    content = mapOf(
        QuizQuestion(content = "content") to listOf(
            QuizAnswer(
                content = "content answer",
                isCorrect = true
            )
        )
    ),
    owner = QuizOwner(name = "owner")
)


val correctQuizStatsDto
    get() = QuizStatsDto(
        impressions = 0,
        likesCount = 0,
        repostCount = 0,
        quizStartCount = 0
    )

val correctQuizContentDto
    get() = QuizContentDto(
        id = 0,
        description = "desc",
        content = mapOf(correctQuizQuestionDto to listOf(correctQuizAnswerDto))
    )

val correctQuizQuestionDto
    get() = QuizQuestionDto(
        content = "content"
    )

val correctQuizAnswerDto
    get() = QuizAnswerDto(
        content = "content answer",
        isCorrect = true
    )

val correctQuizOwnerDto
    get() = QuizOwnerDto(
        name = "owner"
    )