package com.frezzcoding.core.screens.account

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.frezzcoding.core.ui.HomeViewModelImpl
import com.frezzcoding.ui.components.account.AccountScreenComponent

@Composable
fun AccountScreen(
    navController: NavController,
    homeViewModel: HomeViewModelImpl = hiltViewModel()
) {
    AccountScreenComponent(
        //action
    )
}