package com.frezzcoding.core.ui

import com.frezzcoding.HomeUiState
import com.frezzcoding.HomeViewModel
import com.frezzcoding.core.domain.usecase.FetchAdsUseCase
import com.frezzcoding.core.domain.usecase.FetchQuizzesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModelImpl @Inject constructor(
    fetchAdsUseCase: FetchAdsUseCase,
    fetchQuizzesUseCase: FetchQuizzesUseCase
) : HomeViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    override val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = HomeUiState(fetchAdsUseCase.invoke())
    }

}