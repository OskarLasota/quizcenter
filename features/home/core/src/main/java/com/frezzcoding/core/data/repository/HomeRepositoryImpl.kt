package com.frezzcoding.core.data.repository

import android.util.Log
import com.frezzcoding.HomeRepository
import com.frezzcoding.core.FakeApiService
import com.frezzcoding.core.mappers.AdMapper
import com.frezzcoding.core.mappers.QuizMapper
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.snapshots
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

internal class HomeRepositoryImpl @Inject constructor(
    private val apiService: FakeApiService,
    private val adMapper: AdMapper,
    private val quizMapper: QuizMapper,
    private val db: FirebaseFirestore
) : HomeRepository {

    override fun getAds(): Flow<List<AdDetails>> {
        val mappedData = apiService.fetchAds().mapNotNull(adMapper::apply)
        return flowOf(mappedData)
    }

    override fun getQuizzes(): Flow<List<QuizDetails>> {
        val reference = db.collection("/quizzes")
        reference.get()
            .addOnSuccessListener { result ->
                result.forEach { document ->
                    Log.d("firebase firestore", "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener {
                //todo add error handling
            }
        val mappedData = apiService.fetchQuizzes().mapNotNull(quizMapper::apply)
        return flowOf(mappedData)
    }


}