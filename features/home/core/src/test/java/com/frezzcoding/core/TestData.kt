package com.frezzcoding.core

import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.ad.AdOwner
import com.frezzcoding.domain.models.quiz.QuizAnswer
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.domain.models.quiz.QuizQuestion

//todo check if this can be shared through test modules
val baseAdDetails = AdDetails(
    id = 0,
    position = 0,
    text = "text",
    adOwner = AdOwner(name = "adowner"),
    video = "video"
)


val baseQuizModel = QuizDetails(
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
    owner = QuizOwner(name = "owner"),
    video = "correct.video"
)