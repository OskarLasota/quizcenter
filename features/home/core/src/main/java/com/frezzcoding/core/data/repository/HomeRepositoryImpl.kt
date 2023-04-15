package com.frezzcoding.core.data.repository

import com.frezzcoding.network.AdModel
import com.frezzcoding.network.SampleData
import javax.inject.Inject

//todo sampledata is temporary
class HomeRepositoryImpl @Inject constructor(private val dataSource: SampleData) :
    com.frezzcoding.core.domain.repo.HomeRepository {

    override fun getAds(): List<AdModel> {
        return dataSource.advertisementsSample
    }
}