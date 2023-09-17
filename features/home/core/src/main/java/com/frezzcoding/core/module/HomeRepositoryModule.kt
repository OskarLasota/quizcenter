package com.frezzcoding.core.module

import com.frezzcoding.core.data.repository.HomeRepositoryImpl
import com.frezzcoding.core.domain.repo.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class HomeRepositoryModule {

    @Binds
    abstract fun providesHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

}