package com.frezzcoding.core.firebase

import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

// todo add unit tests
class FirestoreWrapper @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    suspend fun getQuizzesCollection(uid: Int): List<DocumentSnapshot> {
        return try {
            val collection = firestore.collection("/quizzes").get().await()
            collection.documents
        } catch (exception: Exception) {
            //Crashlytics
            Log.e("FirestoreWrapper", "Error fetching owner collection for UID: $uid, $exception")
            emptyList()
        }
    }

    suspend fun getOwnerCollection(uid: String): List<DocumentSnapshot>? {
        return try {
            val collection = firestore.collection("/owner").get().await()
            collection.documents
        } catch (exception: Exception) {
            //Crashlytics
            Log.e("FirestoreWrapper", "Error fetching owner collection for UID: $uid, $exception")
            null
        }
    }

    suspend fun getOwnerListCollection(uids: List<Int>): List<DocumentSnapshot>? {
        return try {
            uids.map {
                firestore.collection("/owner").document(it.toString()).get().await()
            }
        } catch (exception: Exception) {
            //Crashlytics
            Log.e("FirestoreWrapper", "Error fetching owner collection, $exception")
            null
        }
    }

    suspend fun getAnswersCollection(ids: List<Int>): List<DocumentSnapshot>? {
        return try {
            ids.map {
                firestore.collection("/answers").document(it.toString()).get().await()
            }
        } catch (e: Exception) {
            Log.e("FirestoreWrapper", "Error fetching owner collection for : $e")
            null
        }
    }

    suspend fun getQuestionCollection(): List<DocumentSnapshot?> {
        return try {
            val collection = firestore.collection("/question").get().await()
            collection.documents
        } catch (e: Exception) {
            Log.e("FirestoreWrapper", "Error fetching question collection for: $e")
            emptyList()
        }
    }

}