package com.frezzcoding.core

import com.frezzcoding.core.domain.QuizMapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test


class QuizMapperTest {


    private val underTest = QuizMapper()


    @Test
    fun `when dto id is null then returns null`() {
        val dto = correctQuizDto.copy(id = null)

        assertNull(underTest.apply(dto))
    }

    @Test
    fun `when dto userId is null then returns null`() {
        val dto = correctQuizDto.copy(userId = null)

        assertNull(underTest.apply(dto))
    }

    @Test
    fun `when dto content description is null then returns null`() {
        val dto = correctQuizDto.copy(content = correctQuizContentDto.copy(description = null))

        assertNull(underTest.apply(dto))
    }

    @Test
    fun `when dto is correct then returns correctly mapped domain model`() {
        val result = underTest.apply(correctQuizDto)

        assertEquals(correctQuizModel, result)
    }

}