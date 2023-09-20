package com.frezzcoding.core.domain.usecase

import com.frezzcoding.HomeRepository
import com.frezzcoding.domain.AdDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchAdsUseCase @Inject constructor(
    private val repo: HomeRepository
) {

    fun invoke(): Flow<List<AdDetails>> {
        return repo.getAds()
    }

}