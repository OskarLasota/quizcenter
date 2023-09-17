package com.frezzcoding.network

import com.frezzcoding.network.ads.AdDto
import com.frezzcoding.network.quiz.QuizAnswerDto
import com.frezzcoding.network.quiz.QuizContentDto
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizQuestionDto

object SampleData {

    val advertisementsSample = listOf(
        AdDto(id = 534, position = 0, text = "test 1"),
        AdDto(id = 534, position = 1, text = "test 2"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
        AdDto(id = 534, position = 2, text = "test 3"),
    )


    val quizSample = listOf(
        quizContent,
        quizContent,
        quizContent,
        quizContent,
        quizContent,
        quizContent,
        quizContent,
    )


    private val quizContent
        get() = QuizDto(
            id = 0, userId = 0, statistics = null, content =
            QuizContentDto(
                id = 0, description = "this is a sample quiz", content = mapOf(
                    QuizQuestionDto("is it sample A?") to listOf(
                        QuizAnswerDto("A", true),
                        QuizAnswerDto("B", false),
                        QuizAnswerDto("C", false),
                        QuizAnswerDto("D", false)
                    )
                )
            )
        )

}