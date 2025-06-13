package com.example.gridexp.features.history.data

import com.example.gridexp.common.data.SavedImageDao
import com.example.gridexp.features.history.domain.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val savedImageDao: SavedImageDao,
) : ImageRepository {

    override suspend fun getImagesFromRoom(): Result<List<String>> {
        return withContext(Dispatchers.IO) {
            try {
                val images = savedImageDao.getAllImages()
                val imagePaths = images.map { it.imagePath }
                Result.success(imagePaths)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}