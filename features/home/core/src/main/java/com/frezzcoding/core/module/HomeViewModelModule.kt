package com.frezzcoding.core.module

import com.frezzcoding.HomeViewModelFactoryProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class HomeViewModelModule {

    @Binds
    abstract fun bindsHomeViewModelFactory(impl: HomeViewModelProviderFactoryImpl): HomeViewModelFactoryProvider

}