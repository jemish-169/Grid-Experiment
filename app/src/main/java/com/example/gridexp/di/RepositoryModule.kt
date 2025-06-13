package com.example.gridexp.di

import android.content.Context
import com.example.gridexp.features.grid.data.GridRepositoryImpl
import com.example.gridexp.features.grid.domain.GridRepository
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
}