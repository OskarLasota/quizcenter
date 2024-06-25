package com.frezzcoding.core.mappers

import com.frezzcoding.domain.models.quiz.QuizOwner
import com.frezzcoding.network.quiz.QuizOwnerDto
import com.google.firebase.firestore.DocumentSnapshot
import javax.inject.Inject

class OwnerDetailsMapper @Inject constructor() {

    fun apply(dto: QuizOwnerDto): QuizOwner? {
        return QuizOwner(
            name = dto.name ?: return null,
            uid = dto.userId ?: return null
        )
    }

    fun snapshotToOwnerDto(snapshot: DocumentSnapshot): QuizOwnerDto {
        return QuizOwnerDto(
            userId = (snapshot.data?.get("userId") as? Long)?.toInt(),
            name = snapshot.data?.get("name") as? String,
        )
    }

}