package com.frezzcoding.core.domain.usecase

import com.frezzcoding.HomeRepository
import com.frezzcoding.domain.models.ad.AdDetails
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchAdsUseCase @Inject constructor(
    private val repo: HomeRepository
) {

    fun invoke(): Flow<List<AdDetails>> {
        return repo.getAds()
    }

}