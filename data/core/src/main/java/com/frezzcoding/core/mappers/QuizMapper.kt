package com.frezzcoding.core.mappers

import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.network.quiz.QuizDto
import com.frezzcoding.network.quiz.QuizOwnerDto
import com.google.firebase.firestore.QueryDocumentSnapshot
import javax.inject.Inject

class QuizMapper @Inject constructor() {

    fun apply(quiz: QuizDto): QuizDetails? {
        if (quiz.id == null) return null
        if (quiz.description == null) return null
        if (quiz.ownerId == null) return null

        return QuizDetails(
            id = quiz.id!!,
            description = quiz.description!!,
            content = emptyMap(),
            owner = QuizOwner("name"),
            video = null
        )
    }

    //todo unit test
    fun snapshotToQuizDto(snapshot: QueryDocumentSnapshot): QuizDto {
        return QuizDto(
            id = snapshot.id.toInt(),
            description = snapshot.data["description"] as? String,
            ownerId = (snapshot.data["ownerId"] as? Long)?.toInt(),
            videoUrl = snapshot.data["videoUrl"] as? String,
        )
    }

}

internal fun QuizOwnerDto.toModel(): QuizOwner {
    return QuizOwner(
        name = this.name
    )
}