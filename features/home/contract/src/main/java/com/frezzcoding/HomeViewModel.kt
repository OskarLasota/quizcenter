package com.frezzcoding

import kotlinx.coroutines.flow.StateFlow

interface HomeViewModel {
    val state: StateFlow<HomeUiState>
}