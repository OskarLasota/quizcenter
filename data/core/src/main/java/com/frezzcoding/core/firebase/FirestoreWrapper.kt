package com.frezzcoding.core.firebase

import android.util.Log
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirestoreWrapper @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    suspend fun getQuizzesCollection(uid: Int): List<DocumentSnapshot> {
        return try {
            val collection = firestore.collection("/quizzes").whereEqualTo("ownerId", uid).get().await()
            collection.documents
        } catch (exception: Exception) {
            //Crashlytics
            Log.e("FirestoreWrapper", "Error fetching owner collection for UID: $uid, $exception")
            emptyList()
        }
    }

    suspend fun getOwnerCollection(uid: String): DocumentSnapshot? {
        return try {
            firestore.collection("/owner").document(uid).get().await()
        } catch (exception: Exception) {
            //Crashlytics
            Log.e("FirestoreWrapper", "Error fetching owner collection for UID: $uid, $exception")
            null
        }
    }

}