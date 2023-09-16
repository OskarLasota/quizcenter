package com.frezzcoding.core.domain.repo

import com.frezzcoding.network.ads.AdDto

interface HomeRepository {
    fun getAds(): List<AdDto>
}