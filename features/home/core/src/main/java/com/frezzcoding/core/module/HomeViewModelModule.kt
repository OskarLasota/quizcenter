package com.frezzcoding.core.module

import com.frezzcoding.HomeViewModel
import com.frezzcoding.core.ui.HomeViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class HomeViewModelModule {

    @Binds
    abstract fun bindsHomeViewModel(impl: HomeViewModelImpl): HomeViewModel
}