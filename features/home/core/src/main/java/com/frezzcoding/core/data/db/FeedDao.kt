package com.frezzcoding.core.data.db

import androidx.room.Dao
import androidx.room.Query

@Dao
interface FeedDao {

    @Query("SELECT * FROM FeedItemEntity")
    suspend fun getFeed(): List<FeedItemEntity>

}