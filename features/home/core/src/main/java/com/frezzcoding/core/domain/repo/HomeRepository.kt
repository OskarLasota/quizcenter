package com.frezzcoding.core.domain.repo

import com.frezzcoding.network.AdModel

interface HomeRepository {
    fun getAds(): List<AdModel>
}