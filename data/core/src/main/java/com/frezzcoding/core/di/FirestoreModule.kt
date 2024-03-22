package com.frezzcoding.core.di

import com.frezzcoding.core.firebase.FirestoreWrapper
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
internal object FirestoreModule {

    @Singleton
    @Provides
    fun providesFirestoreWrapper(firestore: FirebaseFirestore): FirestoreWrapper =
        FirestoreWrapper(firestore)

}