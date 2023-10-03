package com.frezzcoding.core

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.data.repository.HomeRepositoryImpl
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.QuizMapper
import org.junit.Before
import org.junit.Test

class HomeRepositoryImplTest {

    lateinit var underTest: HomeRepository


    @Before
    fun setup() {
        underTest = HomeRepositoryImpl(FakeApiService(), AdMapper(), QuizMapper())
    }

    @Test
    fun `when ads mapper returns null models getAds returns empty list`() {
        val result = underTest.getAds()


    }

    @Test
    fun `when quiz mapper returns null models getQuizzes returns empty list`() {
        val result = underTest.getQuizzes()
    }

}