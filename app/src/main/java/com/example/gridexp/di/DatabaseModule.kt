package com.example.gridexp.di

import android.content.Context
import androidx.room.Room
import com.example.gridexp.common.data.SavedImageDao
import com.example.gridexp.core.db.ImageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): ImageDatabase {
        return Room.databaseBuilder(
            context,
            ImageDatabase::class.java,
            "image_database"
        ).build()
    }

    @Provides
    fun provideImageDao(database: ImageDatabase): SavedImageDao {
        return database.imageDao()
    }
}