package com.frezzcoding.core.mappers

import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.ad.AdOwner
import com.frezzcoding.network.ads.AdDto
import javax.inject.Inject

class AdMapper @Inject constructor() {

    fun apply(adModel: AdDto): AdDetails? {
        if (adModel.id == null) return null
        if (adModel.position == null) return null
        if (adModel.text == null) return null
        if (adModel.adOwner == null) return null

        return AdDetails(
            id = adModel.id!!,
            position = adModel.position!!,
            text = adModel.text!!,
            adOwner = AdOwner(name = adModel.adOwner!!.name)
        )
    }

}