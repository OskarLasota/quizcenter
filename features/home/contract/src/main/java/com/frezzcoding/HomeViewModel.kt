package com.frezzcoding

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class HomeViewModel : ViewModel() {

    abstract val state: StateFlow<HomeUiState>

}