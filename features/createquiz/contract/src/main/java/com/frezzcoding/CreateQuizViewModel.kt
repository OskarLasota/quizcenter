package com.frezzcoding

import kotlinx.coroutines.flow.StateFlow

interface CreateQuizViewModel {
    val uiState: StateFlow<CreateQuizUiState>
    fun onCreateQuizAction()
    fun onQuizScreenClosed()
}