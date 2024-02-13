package com.frezzcoding

sealed class CreateQuizUiState {
    data object LoadingState: CreateQuizUiState()

}