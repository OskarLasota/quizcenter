package com.frezzcoding.core.domain.usecase

import com.frezzcoding.core.AdMapper
import com.frezzcoding.core.domain.repo.HomeRepository
import com.frezzcoding.domain.AdDetails
import javax.inject.Inject

class FetchAdsUseCase @Inject constructor(
    private val repo: HomeRepository,
    private val adMapper: AdMapper
) {

    fun invoke(): List<AdDetails> {
        return repo.getAds().mapNotNull(adMapper::apply)
    }

}