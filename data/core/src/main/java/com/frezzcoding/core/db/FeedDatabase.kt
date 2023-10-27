package com.frezzcoding.core.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FeedItemEntity::class], version = 2, exportSchema = false)
abstract class FeedDatabase : RoomDatabase() {

    abstract fun feedDao(): FeedDao

}