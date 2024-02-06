package com.frezzcoding.core

import com.frezzcoding.CreateQuizViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class CreateQuizViewModelModule {

    @Binds
    abstract fun bindsQuizViewModel(impl: CreateQuizViewModelImpl): CreateQuizViewModel

}