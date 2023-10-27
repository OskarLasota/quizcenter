package com.frezzcoding.core.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FeedDao {

    @Query("SELECT * FROM FeedItemEntity")
    suspend fun getFeed(): List<FeedItemEntity>

    @Insert
    suspend fun addItem(item: FeedItemEntity)

    @Update
    suspend fun updateItem(item: FeedItemEntity)

    @Delete
    suspend fun deleteItem(item: FeedItemEntity)

}