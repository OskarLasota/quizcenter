package com.frezzcoding.quizcenter.presentation.ui.home

import com.frezzcoding.quizcenter.domain.HomeRepository
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(private val dataSource: SampleData) : HomeRepository {

    override fun getAds(): List<AdModel> {
        return dataSource.advertisementsSample
    }
}
