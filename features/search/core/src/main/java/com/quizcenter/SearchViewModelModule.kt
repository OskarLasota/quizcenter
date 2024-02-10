package com.quizcenter

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
internal abstract class SearchViewModelModule {

    @Binds
    abstract fun bindsSearchViewModel(impl: SearchViewModelImpl): SearchViewModel

}