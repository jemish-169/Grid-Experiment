package com.example.gridexp.common.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.gridexp.common.data.entity.SavedImage

@Dao
interface SavedImageDao {
    @Query("SELECT * FROM images ORDER BY created_at DESC")
    suspend fun getAllImages(): List<SavedImage>

    @Insert(onConflict = OnConflictStrategy.REPLACE)

    suspend fun insertImage(image: SavedImage)
}