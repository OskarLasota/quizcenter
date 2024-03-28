package com.frezzcoding.core

import androidx.lifecycle.ViewModel
import com.frezzcoding.CreateQuizUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateQuizViewModel @Inject constructor() : ViewModel() {


    fun onCreateQuizAction() {
        // make call to data layer
        // return state
    }

    fun onQuizScreenClosed() {
        // make analytics call
    }

}