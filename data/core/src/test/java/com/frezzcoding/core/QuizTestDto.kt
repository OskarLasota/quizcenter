package com.frezzcoding.core

import com.frezzcoding.domain.models.quiz.QuizAnswer
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.domain.models.quiz.QuizQuestion
import com.frezzcoding.network.answers.AnswerDto
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizOwnerDto

val correctQuizDto = QuizDto(
    id = 123,
    ownerId = 123,
    description = "desc",
    question = "question",
    videoUrl = "videoUrl"
)

val correctQuizModel = QuizDetails(
    id = 123,
    description = "desc",
    content = mapOf(
        QuizQuestion("question") to listOf(
            QuizAnswer("first answer", true),
            QuizAnswer("second answer", false),
            QuizAnswer("third answer", false)
        )
    ),
    owner = QuizOwner("john", 1),
    video = null
)

val questionWithEmptyAnswers = mapOf(
    QuizQuestion("question") to listOf(
        QuizAnswer("", true),
        QuizAnswer("", false),
        QuizAnswer("", false)
    )
)

val correctQuizOwnerDto
    get() = QuizOwnerDto(
        userId = 1,
        name = "john"
    )

val correctQuizAnswerDto
    get() = AnswerDto(
        quizId = 0,
        firstAnswer = "first answer",
        secondAnswer = "second answer",
        thirdAnswer = "third answer"
    )