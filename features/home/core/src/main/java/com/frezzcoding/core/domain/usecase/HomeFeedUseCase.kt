package com.frezzcoding.core.domain.usecase

import com.frezzcoding.core.domain.repo.HomeRepository
import com.frezzcoding.domain.Ad
import javax.inject.Inject

class HomeFeedUseCase @Inject constructor(repo: HomeRepository) {

    fun getAds(): List<Ad> {
        return emptyList()
    }

}