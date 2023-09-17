package com.frezzcoding.core.screens.home

import androidx.lifecycle.ViewModel
import com.frezzcoding.core.domain.usecase.FetchAdsUseCase
import com.frezzcoding.core.domain.usecase.FetchQuizzesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    fetchAdsUseCase: FetchAdsUseCase,
    fetchQuizzesUseCase: FetchQuizzesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = HomeUiState(fetchAdsUseCase.invoke())
    }

}