package com.frezzcoding.core

import com.frezzcoding.core.mappers.AdMapper
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class AdMapperTest {


    private val underTest = AdMapper()


    @Test
    fun `when dto id is null then returns null`() {
        assertNull(underTest.apply(correctAdDto.copy(id = null)))
    }

    @Test
    fun `when dto position is null then returns null`() {
        assertNull(underTest.apply(correctAdDto.copy(position = null)))
    }

    @Test
    fun `when dto text is null then returns null`() {
        assertNull(underTest.apply(correctAdDto.copy(text = null)))
    }

    @Test
    fun `when dto adOwner is null then returns null`() {
        assertNull(underTest.apply(correctAdDto.copy(adOwner = null)))
    }

    @Test
    fun `when dto is correct then returns mapped domain model`() {
        val result = underTest.apply(correctAdDto)

        assertEquals(correctAdDomainModel, result)
    }

}