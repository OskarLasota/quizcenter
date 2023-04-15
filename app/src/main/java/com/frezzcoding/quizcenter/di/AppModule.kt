package com.frezzcoding.quizcenter.di

import com.frezzcoding.core.HomeRepository
import com.frezzcoding.domain.SampleData
import com.frezzcoding.core.HomeRepositoryImpl
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
    abstract fun provideHomeRepository(impl: com.frezzcoding.core.HomeRepositoryImpl): com.frezzcoding.core.HomeRepository

//    @Binds
//    abstract fun provideHomeViewModel(impl: HomeViewModel): HomeViewModel
}

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideSampleData() = com.frezzcoding.domain.SampleData

}