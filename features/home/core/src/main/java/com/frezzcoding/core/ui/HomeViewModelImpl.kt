package com.frezzcoding.core.ui

import android.util.Log
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
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class HomeViewModelImpl @Inject constructor(
    private val fetchAdsUseCase: FetchAdsUseCase,
    private val fetchQuizzesUseCase: FetchQuizzesUseCase,
    override val player: MediaPlayerManager,
) : HomeViewModel, ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    override val state: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var previousViewed: Int? = 0

    override fun getFeed() {
        //combine the flows of both use cases
        viewModelScope.launch {
            combine(
                fetchQuizzesUseCase.invoke(),
                fetchAdsUseCase.invoke()
            ) { quizzes, ads ->
                HomeUiState(ads, quizzes)
            }.catch {
                Log.e("HomeViewModelImpl", "issue found : $it")
            }.onEach { newState ->
                _uiState.value = newState
            }.collect {
                it
            }

        }
    }

    override fun playVideo(quiz: QuizDetails?) {
        if (quiz?.video != null && previousViewed != quiz.id) {
            player.playVideo(quiz.id)
            previousViewed = quiz.id
        }
    }

}