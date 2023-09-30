package com.frezzcoding.domain.models.ad

import com.frezzcoding.domain.models.FeedItem

data class AdDetails(
    val id: Int,
    val position: Int,
    val text: String,
    val adOwner: AdOwner
) : FeedItem