package com.frezzcoding.core

import com.example.media.MediaPlayerManager
import com.frezzcoding.HomeUiState
import com.frezzcoding.core.domain.usecase.FetchAdsUseCase
import com.frezzcoding.core.domain.usecase.FetchQuizzesUseCase
import com.frezzcoding.core.ui.HomeViewModelImpl
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HomeViewModelImplTest {

    @MockK
    private lateinit var adsUseCase: FetchAdsUseCase

    @MockK
    private lateinit var quizUseCase: FetchQuizzesUseCase

    @MockK
    private lateinit var mediaPlayerManager: MediaPlayerManager

    private val testDispatcher = TestCoroutineDispatcher()

    @InjectMockKs
    private lateinit var underTest: HomeViewModelImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `getFeed invokes correct use cases`() = runBlocking {
        val expectedAds = listOf(baseAdDetails, baseAdDetails)
        val expectedQuizzes = listOf(baseQuizModel, baseQuizModel)
        every { adsUseCase.invoke() } returns flowOf(expectedAds)
        every { quizUseCase.invoke() } returns flowOf(expectedQuizzes)

        underTest.getFeed()

        verify { adsUseCase.invoke() }
        verify { quizUseCase.invoke() }
    }

    @Test
    fun `getFeed sets the ui state correctly`() = runBlocking {
        val expectedAds = listOf(baseAdDetails, baseAdDetails)
        val expectedQuizzes = listOf(baseQuizModel, baseQuizModel)
        every { adsUseCase.invoke() } returns flowOf(expectedAds)
        every { quizUseCase.invoke() } returns flowOf(expectedQuizzes)

        underTest.getFeed()

        val uiState = underTest.state.value
        val expectedState = HomeUiState(expectedAds, expectedQuizzes)

        assertEquals(expectedState, uiState)
    }

}