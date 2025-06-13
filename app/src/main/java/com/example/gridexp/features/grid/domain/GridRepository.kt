package com.example.gridexp.features.grid.domain

interface GridRepository {
    suspend fun saveAsImage(text: String): Result<String>
}