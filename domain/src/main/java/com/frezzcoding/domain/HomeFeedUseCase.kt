package com.frezzcoding.domain

import javax.inject.Inject

class HomeFeedUseCase @Inject constructor(repo: HomeRepository) {

    fun getAds(): List<Ad> {
        return emptyList()
    }

}