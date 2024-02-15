package com.frezzcoding

sealed class CreateQuizUiState {
    data object LoadingState: CreateQuizUiState()
    data class ErrorState(val errorMessage: String): CreateQuizUiState()

}