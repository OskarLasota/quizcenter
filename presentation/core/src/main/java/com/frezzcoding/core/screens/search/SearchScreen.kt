package com.frezzcoding.core.screens.search

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.frezzcoding.core.ui.HomeViewModelImpl
import com.frezzcoding.ui.components.search.SearchScreenComponent

@Composable
fun SearchScreen(
    navController: NavController,
    homeViewModel: HomeViewModelImpl = hiltViewModel()
) {

    SearchScreenComponent(
        //onAction
    )
}