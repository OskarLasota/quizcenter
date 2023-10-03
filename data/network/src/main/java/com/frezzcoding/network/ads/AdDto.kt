package com.frezzcoding.network.ads

data class AdDto(
    val id: Int?,
    val position: Int?,
    val text: String?,
    val adOwner: AdOwnerDto?,
    val video: String?
)