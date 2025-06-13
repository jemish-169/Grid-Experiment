package com.example.gridexp.di

import android.content.Context
import com.example.gridexp.common.data.SavedImageDao
import com.example.gridexp.features.grid.data.GridRepositoryImpl
import com.example.gridexp.features.grid.domain.GridRepository
import com.example.gridexp.features.history.data.HistoryRepositoryImpl
import com.example.gridexp.features.history.data.ImageRepositoryImpl
import com.example.gridexp.features.history.domain.HistoryRepository
import com.example.gridexp.features.history.domain.ImageRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideGridRepository(
        @ApplicationContext context: Context,
        savedImageDao: SavedImageDao
    ): GridRepository = GridRepositoryImpl(context = context, savedImageDao = savedImageDao)

    @Singleton
    @Provides
    fun provideHistoryRepository(
        @ApplicationContext context: Context,
    ): HistoryRepository =
        HistoryRepositoryImpl(context = context)

    @Singleton
    @Provides
    fun provideImageRepository(
        savedImageDao: SavedImageDao
    ): ImageRepository =
        ImageRepositoryImpl(savedImageDao = savedImageDao)
}