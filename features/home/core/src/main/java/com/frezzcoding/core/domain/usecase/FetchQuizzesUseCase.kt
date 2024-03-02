package com.frezzcoding.core.domain.usecase

import com.frezzcoding.HomeRepository
import com.frezzcoding.domain.models.quiz.QuizDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class FetchQuizzesUseCase @Inject constructor(
    private val repo: HomeRepository,
    //loggedinuserinfo
) {

    fun invoke(): Flow<List<QuizDetails>> {
        return repo.getQuizzes(0)
    }

}