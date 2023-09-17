package com.frezzcoding.core.screens.home

import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails
import java.util.Collections.emptyList

data class HomeUiState(val ads: List<AdDetails> = emptyList(), val quizzes: List<QuizDetails>)