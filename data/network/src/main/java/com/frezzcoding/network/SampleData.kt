package com.frezzcoding.network

import com.frezzcoding.network.ads.AdDto
import com.frezzcoding.network.ads.AdOwnerDto
import com.frezzcoding.network.quiz.QuizAnswerDto
import com.frezzcoding.network.quiz.QuizContentDto
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizOwnerDto
import com.frezzcoding.network.quiz.QuizQuestionDto
import com.frezzcoding.network.quiz.QuizStatsDto

object SampleData {

    val advertisementsSample = listOf(
        AdDto(
            id = 534,
            position = 0,
            text = "test 1, test 1test 1test 1test 1test 1test 1test 1test 1test 1test 1test 1test 1test 1test 1test 1",
            AdOwnerDto("Mazda")
        ),
        AdDto(id = 111, position = 1, text = "test 2", AdOwnerDto("SpaceX")),
        AdDto(id = 112, position = 2, text = "test 3", AdOwnerDto("Tesla")),
        AdDto(id = 113, position = 2, text = "test 3", AdOwnerDto("Tesla")),
        AdDto(id = 114, position = 2, text = "test 3", AdOwnerDto("Tesla")),
    )


    val quizSample = listOf(
        quizContent.copy(id = 1, video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        quizContent.copy(id = 2, video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        quizContent.copy(id = 3, video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
        quizContent.copy(id = 4, video = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"),
    )


    private val quizContent
        get() = QuizDto(
            id = 0, userId = 0, statistics = QuizStatsDto(), content =
            QuizContentDto(
                id = 0,
                description = "this is a sample quiz this is a sample quizthis is a sample quizthis is a sample quiz",
                content = mapOf(
                    QuizQuestionDto("is it sample A?") to listOf(
                        QuizAnswerDto("A", true),
                        QuizAnswerDto("B", false),
                        QuizAnswerDto("C", false),
                        QuizAnswerDto("D", false)
                    )
                )
            ),
            owner = QuizOwnerDto(name = "owner"),
            video = null
        )

}