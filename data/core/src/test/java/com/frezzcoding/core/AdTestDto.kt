package com.frezzcoding.core

import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.ad.AdOwner
import com.frezzcoding.network.ads.AdDto
import com.frezzcoding.network.ads.AdOwnerDto

val correctAdDto
    get() = AdDto(
        id = 0,
        position = 0,
        text = "ad",
        adOwner = correctAdOwnerDto,
        video = null
    )

val correctAdOwnerDto
    get() = AdOwnerDto(
        name = "ad owner"
    )

val correctAdDomainModel
    get() = AdDetails(
        id = 0,
        position = 0,
        text = "ad",
        adOwner = AdOwner(name = "ad owner"),
        video = null
    )