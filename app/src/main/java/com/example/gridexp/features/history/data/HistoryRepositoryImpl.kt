package com.example.gridexp.features.history.data

import android.content.Context
import com.example.gridexp.features.history.domain.HistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val context: Context
) : HistoryRepository {

    override suspend fun getImagesFromInternalStorage(): Result<List<String>> {
        return withContext(Dispatchers.IO) {
            val imageFiles = mutableListOf<String>()
            val filesDir = context.filesDir

            try {
                val files = filesDir.listFiles { file ->
                    file.isFile && file.extension.lowercase() == "png"
                }

                files?.sortByDescending { it.lastModified() }

                files?.forEach { file ->
                    imageFiles.add(file.absolutePath)
                }
                Result.success(imageFiles)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}