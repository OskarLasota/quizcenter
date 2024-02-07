package com.frezzcoding.core

import androidx.lifecycle.ViewModel
import com.frezzcoding.CreateQuizViewModel
import javax.inject.Inject

internal class CreateQuizViewModelImpl @Inject constructor() : CreateQuizViewModel, ViewModel() {

    override fun onCreateQuizAction() {
        // make call to data layer
        // return state
    }

    override fun onQuizScreenClosed() {
        // make analytics call
    }

}