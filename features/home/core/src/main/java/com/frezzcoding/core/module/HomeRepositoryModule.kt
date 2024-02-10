package com.frezzcoding.core.module

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.data.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class HomeRepositoryModule {

    @Binds
    abstract fun bindsHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

}