package com.frezzcoding.core

import androidx.lifecycle.ViewModel
import com.frezzcoding.CreateQuizUiState
import com.frezzcoding.CreateQuizViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

internal class CreateQuizViewModelImpl @Inject constructor() : CreateQuizViewModel, ViewModel() {

    private val _uiState: MutableStateFlow<CreateQuizUiState> = MutableStateFlow(CreateQuizUiState.LoadingState)

    override fun onCreateQuizAction() {
        // make call to data layer
        // return state
    }

    override fun onQuizScreenClosed() {
        // make analytics call
    }

}