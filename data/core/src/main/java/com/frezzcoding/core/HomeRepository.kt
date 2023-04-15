package com.frezzcoding.quizcenter.domain

interface HomeRepository {
    fun getAds(): List<com.frezzcoding.domain.AdModel>
}