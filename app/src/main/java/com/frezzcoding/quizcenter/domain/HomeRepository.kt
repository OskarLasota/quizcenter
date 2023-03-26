package com.frezzcoding.quizcenter.domain

interface HomeRepository {
    fun getAds(): List<AdModel>
}