package com.frezzcoding.core.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.media.MediaPlayerManager
import com.frezzcoding.HomeUiState
import com.frezzcoding.HomeViewModel
import com.frezzcoding.core.domain.usecase.FetchAdsUseCase
import com.frezzcoding.core.domain.usecase.FetchQuizzesUseCase
import com.frezzcoding.domain.models.quiz.QuizDetails
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class HomeViewModelImpl @Inject constructor(
    private val fetchAdsUseCase: FetchAdsUseCase,
    private val fetchQuizzesUseCase: FetchQuizzesUseCase,
    override val player: MediaPlayerManager,
) : HomeViewModel, ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    override val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    override fun getFeed() {
        //combine the flows of both use cases
        combine(
            fetchQuizzesUseCase.invoke(),
            fetchAdsUseCase.invoke()
        ) { quizzes, ads ->
            HomeUiState(ads, quizzes)
        }.onEach { newState ->
            _uiState.value = newState
        }.launchIn(viewModelScope)

    }

    override fun playVideo(quiz: QuizDetails?) {
        player.playVideo()
    }

}