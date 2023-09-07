package com.frezzcoding.core.domain.usecase

import com.frezzcoding.core.AdMapper
import com.frezzcoding.core.domain.repo.HomeRepository
import com.frezzcoding.domain.Ad
import javax.inject.Inject

class HomeFeedUseCase @Inject constructor(
    private val repo: HomeRepository,
    private val adMapper: AdMapper
) {

    fun getAds(): List<Ad> {
        return repo.getAds().map(adMapper::apply)
    }

}