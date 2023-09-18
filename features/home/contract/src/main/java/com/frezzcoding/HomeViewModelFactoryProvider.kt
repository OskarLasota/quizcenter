package com.frezzcoding

import androidx.fragment.app.FragmentActivity

interface HomeViewModelFactoryProvider {
    fun get(hiltActivity: FragmentActivity): HomeViewModel
}