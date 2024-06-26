package com.frezzcoding.core

import android.util.Log
import com.frezzcoding.core.mappers.QuizMapper
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test


class QuizMapperTest {

    private val underTest = QuizMapper()

    @Before
    fun setup() {
        mockkStatic(Log::class)
        every { Log.e(any(), any()) } returns 0
    }

    @Test
    fun `when quiz id is null then returns null`() {
        val quiz = correctQuizDto.copy(id = null)

        assertNull(underTest.apply(quiz, correctQuizAnswerDto, correctQuizOwnerDto))
    }

    @Test
    fun `when quiz ownerId is null then returns null`() {
        val quiz = correctQuizDto.copy(ownerId = null)

        assertNull(underTest.apply(quiz, correctQuizAnswerDto, correctQuizOwnerDto))
    }

    @Test
    fun `when quiz description is null then returns null`() {
        val quiz = correctQuizDto.copy(description = null)

        assertNull(underTest.apply(quiz, correctQuizAnswerDto, correctQuizOwnerDto))
    }

    @Test
    fun `when answer is null then returns null`() {
        assertNull(underTest.apply(correctQuizDto, null, correctQuizOwnerDto))
    }

    @Test
    fun `when owner is null then returns null`() {
        assertNull(underTest.apply(correctQuizDto, correctQuizAnswerDto, null))
    }

    @Test
    fun `when owner user id is null then returns null`() {
        val owner = correctQuizOwnerDto.copy(userId = null)

        assertNull(underTest.apply(correctQuizDto, correctQuizAnswerDto, owner))
    }

    @Test
    fun `maps QuizDetails correctly`() {
        val result = underTest.apply(correctQuizDto, correctQuizAnswerDto, correctQuizOwnerDto)

        assertEquals(correctQuizModel, result)
    }

    @Test
    fun `when answers are null then return empty`() {
        val emptyAnswers = correctQuizAnswerDto.copy(
            firstAnswer = null,
            secondAnswer = null,
            thirdAnswer = null
        )
        val result = underTest.apply(correctQuizDto, emptyAnswers, correctQuizOwnerDto)

        assertEquals(correctQuizModel.copy(content = questionWithEmptyAnswers), result)
    }

}