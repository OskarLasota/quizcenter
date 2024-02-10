package com.frezzcoding.core.di

import com.frezzcoding.core.ui.AccountViewModelImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class AccountViewModelModule {

    @Binds
    abstract fun bindsAccountViewModel(impl: AccountViewModelImpl): AccountViewModelImpl

}