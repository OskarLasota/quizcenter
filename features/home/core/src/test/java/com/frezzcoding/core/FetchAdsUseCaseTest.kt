package com.frezzcoding.core

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.domain.usecase.FetchAdsUseCase
import com.frezzcoding.domain.models.ad.AdDetails
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class FetchAdsUseCaseTest {

    @MockK
    private lateinit var homeRepository: HomeRepository

    @InjectMockKs
    private lateinit var underTest: FetchAdsUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `verify use case calls the correct repo and returns repo result`() {
        val expected = flowOf(emptyList<AdDetails>())
        every { homeRepository.getAds() } returns expected

        val result = underTest.invoke()

        verify { homeRepository.getAds() }
        assertEquals(expected, result)
    }

}