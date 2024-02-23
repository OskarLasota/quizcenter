package com.frezzcoding.core.module

import com.frezzcoding.HomeRepository
import com.frezzcoding.core.data.repository.HomeRepositoryImpl
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal abstract class HomeRepositoryModule {

    @Binds
    abstract fun bindsHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

}

@InstallIn(SingletonComponent::class)
@Module
internal object FirebaseDatabaseModule {

    @Singleton
    @Provides
    fun providesFirebaseFirestore(): FirebaseFirestore =
        Firebase.firestore

}