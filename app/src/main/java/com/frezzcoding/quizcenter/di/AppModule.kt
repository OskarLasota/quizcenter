package com.frezzcoding.quizcenter.di

import com.frezzcoding.quizcenter.domain.HomeRepository
import com.frezzcoding.quizcenter.domain.SampleData
import com.frezzcoding.quizcenter.presentation.ui.home.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun provideHomeRepository(impl: HomeRepositoryImpl): HomeRepository

//    @Binds
//    abstract fun provideHomeViewModel(impl: HomeViewModel): HomeViewModel
}

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideSampleData() = SampleData

}