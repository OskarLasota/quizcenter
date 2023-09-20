package com.frezzcoding.core.domain.usecase

import com.frezzcoding.HomeRepository
import com.frezzcoding.domain.QuizDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchQuizzesUseCase @Inject constructor(
    private val repo: HomeRepository,
) {

    fun invoke(): Flow<List<QuizDetails>> {
        return repo.getQuizzes()
    }

}