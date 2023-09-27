package com.frezzcoding.core.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FeedItemEntity(@PrimaryKey val id: Int, @ColumnInfo val content: String)