package com.frezzcoding.core.screens

import com.frezzcoding.domain.Ad
import java.util.Collections.emptyList

data class HomeUiState(val list: List<Ad> = emptyList())