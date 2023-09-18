package com.frezzcoding.core.module

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.frezzcoding.HomeViewModel
import com.frezzcoding.HomeViewModelFactoryProvider
import com.frezzcoding.core.ui.HomeViewModelImpl
import javax.inject.Inject

class HomeViewModelProviderFactoryImpl @Inject constructor() : HomeViewModelFactoryProvider {

    override fun get(hiltActivity: FragmentActivity): HomeViewModel =
        ViewModelProvider(hiltActivity)[HomeViewModelImpl::class.java]
}