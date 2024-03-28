package com.frezzcoding.core

import com.frezzcoding.NewQuizComponent
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
internal abstract class CreateQuizModule {

    @Binds
    abstract fun bindsNewQuizComponent(impl: NewQuizComponentImpl): NewQuizComponent

}
