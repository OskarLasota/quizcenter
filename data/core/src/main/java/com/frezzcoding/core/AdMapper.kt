package com.frezzcoding.core

import com.frezzcoding.domain.Ad
import com.frezzcoding.network.AdModel
import javax.inject.Inject

class AdMapper @Inject constructor() {

    fun apply(adModel: AdModel): Ad {
        return Ad(
            id = adModel.id,
            position = adModel.position,
            text = adModel.text
        )
    }

}