package com.example.gridexp.features.history.data

import android.content.Context
import com.example.gridexp.R
import com.example.gridexp.di.ResourceManager
import com.example.gridexp.features.history.domain.HistoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val context: Context,
    private val resourceManager: ResourceManager
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
                Result.failure(
                    Exception(
                        e.message ?: resourceManager.getString(R.string.something_went_wrong)
                    )
                )
            }
        }
    }
}