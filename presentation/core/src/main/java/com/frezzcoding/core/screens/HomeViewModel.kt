package com.frezzcoding.core.screens

import androidx.lifecycle.ViewModel
import com.frezzcoding.core.domain.usecase.HomeFeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(useCase: com.frezzcoding.core.domain.usecase.HomeFeedUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = HomeUiState(useCase.getAds())
    }

}