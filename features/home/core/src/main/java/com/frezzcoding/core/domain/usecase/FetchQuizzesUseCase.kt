package com.frezzcoding.core.domain.usecase

import com.frezzcoding.core.domain.repo.HomeRepository
import com.frezzcoding.domain.QuizDetails
import javax.inject.Inject

class FetchQuizzesUseCase @Inject constructor(
    private val repo: HomeRepository,
    private val quizMapper: QuizMapper
) {

    fun invoke(): List<QuizDetails> {
        return repo.getQuizzes().mapNotNull(quizMapper::apply)
    }

}