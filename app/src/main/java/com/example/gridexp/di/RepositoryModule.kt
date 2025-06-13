package com.example.gridexp.di

import android.content.Context
import com.example.gridexp.features.grid.data.GridRepositoryImpl
import com.example.gridexp.features.grid.domain.GridRepository
import com.example.gridexp.features.history.data.HistoryRepositoryImpl
import com.example.gridexp.features.history.domain.HistoryRepository
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
        @ApplicationContext context: Context
    ): GridRepository = GridRepositoryImpl(context = context)

    @Singleton
    @Provides
    fun provideHistory(
        @ApplicationContext context: Context,
        resourceManager: ResourceManager
    ): HistoryRepository =
        HistoryRepositoryImpl(context = context, resourceManager = resourceManager)
}