package com.frezzcoding.core.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FeedDao {

    @Query("SELECT * FROM FeedItemEntity")
    fun getFeed(): List<FeedItemEntity>

    @Insert
    fun addItem(item: FeedItemEntity)

    @Update
    fun updateItem(item: FeedItemEntity)

    @Delete
    fun deleteItem(item: FeedItemEntity)

}