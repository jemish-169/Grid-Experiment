package com.example.gridexp.features.history.domain

interface ImageRepository {
    suspend fun getImagesFromRoom(): Result<List<String>>
}