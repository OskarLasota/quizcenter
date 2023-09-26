package com.frezzcoding.core

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.data.repository.HomeRepositoryImpl
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.QuizMapper
import org.junit.Before

class HomeRepositoryImplTest {

    lateinit var underTest: HomeRepository


    @Before
    fun setup() {
        underTest = HomeRepositoryImpl(AdMapper(), QuizMapper())
    }

}