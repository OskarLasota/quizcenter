package com.frezzcoding.core

import com.frezzcoding.core.mappers.QuizMapper
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

    @Test
    fun `when dto video is null map null to domain`() {
        val result = underTest.apply(correctQuizDto.copy(video = null))

        assertEquals(correctQuizModel.copy(video = null), result)
    }

}