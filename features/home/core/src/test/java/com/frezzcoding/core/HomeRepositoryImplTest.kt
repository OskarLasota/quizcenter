package com.frezzcoding.core

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.data.repository.HomeRepositoryImpl
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.QuizMapper
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeRepositoryImplTest {

    @MockK
    lateinit var adMapper: AdMapper

    @MockK
    lateinit var quizMapper: QuizMapper

    lateinit var underTest: HomeRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        underTest = HomeRepositoryImpl(FakeApiService(), AdMapper(), QuizMapper())
    }

    @Test
    fun `when ads mapper returns null models getAds returns empty list`() {
        every { adMapper.apply(any()) } returns null

        val result = underTest.getAds()

        assertEquals(emptyList<AdDetails>(), result)
        verify { adMapper.apply(any()) }
    }

    @Test
    fun `when quiz mapper returns null models getQuizzes returns empty list`() = runTest {
        every { quizMapper.apply(any()) } returns null

        val result = underTest.getQuizzes()

        assertEquals(emptyList<QuizDetails>(), result)
        verify { quizMapper.apply(any()) }
    }

}