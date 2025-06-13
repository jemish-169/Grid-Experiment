package com.example.gridexp.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gridexp.common.data.SavedImageDao
import com.example.gridexp.common.data.entity.SavedImage

@Database(
    entities = [SavedImage::class],
    version = 1,
    exportSchema = false
)

abstract class ImageDatabase : RoomDatabase() {
    abstract fun imageDao(): SavedImageDao
}