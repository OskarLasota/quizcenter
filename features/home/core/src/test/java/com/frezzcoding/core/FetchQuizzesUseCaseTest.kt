package com.frezzcoding.core

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.domain.usecase.FetchQuizzesUseCase
import com.frezzcoding.domain.models.quiz.QuizDetails
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FetchQuizzesUseCaseTest {

    @MockK
    private lateinit var homeRepository: HomeRepository

    @InjectMockKs
    private lateinit var underTest: FetchQuizzesUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `verify use case calls the correct repo and returns repo result`() {
        val expected = flowOf(emptyList<QuizDetails>())
        every { homeRepository.getQuizzes() } returns expected

        val result = underTest.invoke()

        verify { homeRepository.getQuizzes() }
        assertEquals(expected, result)
    }

}