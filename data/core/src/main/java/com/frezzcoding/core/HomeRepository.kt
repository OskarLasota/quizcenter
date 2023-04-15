package com.frezzcoding.core

import com.frezzcoding.network.AdModel

interface HomeRepository {
    fun getAds(): List<AdModel>
}