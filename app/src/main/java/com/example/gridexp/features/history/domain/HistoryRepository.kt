package com.example.gridexp.features.history.domain

interface HistoryRepository {
    suspend fun getImagesFromInternalStorage(): Result<List<String>>
}