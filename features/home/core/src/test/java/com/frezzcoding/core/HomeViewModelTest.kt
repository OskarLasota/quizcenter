package com.frezzcoding.core

import androidx.media3.common.Player
import com.frezzcoding.HomeViewModel
import com.frezzcoding.core.domain.usecase.FetchAdsUseCase
import com.frezzcoding.core.domain.usecase.FetchQuizzesUseCase
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    @MockK
    private lateinit var adsUseCase: FetchAdsUseCase

    @MockK
    private lateinit var quizUseCase: FetchQuizzesUseCase

    @MockK
    private lateinit var player: Player

    @InjectMockKs
    private lateinit var underTest: HomeViewModel

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `getFeed invokes correct use cases`() {
        underTest.getFeed()

        verify { adsUseCase.invoke() }
        verify { quizUseCase.invoke() }
    }

}