package com.frezzcoding.quizcenter.presentation.ui.home

import androidx.lifecycle.ViewModel
import com.frezzcoding.quizcenter.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repo: HomeRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        _uiState.value = HomeUiState(repo.getAds())
    }

}