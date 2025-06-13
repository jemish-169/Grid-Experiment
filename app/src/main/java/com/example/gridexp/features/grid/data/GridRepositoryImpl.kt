package com.example.gridexp.features.grid.data

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import androidx.core.graphics.createBitmap
import com.example.gridexp.common.data.SavedImageDao
import com.example.gridexp.common.data.entity.SavedImage
import com.example.gridexp.features.grid.domain.GridRepository
import com.example.gridexp.features.grid.domain.Utils.getRandomColorPair
import java.io.File
import javax.inject.Inject


class GridRepositoryImpl @Inject constructor(
    private val context: Context,
    private val savedImageDao: SavedImageDao
) : GridRepository {
    override suspend fun saveAsImage(text: String): Result<String> {
        return try {
            val bitmap = createBitmap(200, 200)
            val canvas = Canvas(bitmap)
            val colorPair = getRandomColorPair()
            canvas.drawColor(colorPair.first)

            val paint = Paint().apply {
                color = colorPair.second
                textSize = 24f
                isAntiAlias = true
                textAlign = Paint.Align.CENTER
            }

            val x = 100f
            val y = 100f
            canvas.drawText(text, x, y, paint)

            val timestamp = System.currentTimeMillis()
            val filename = "image_$timestamp.png" // we can save as WEBP to reduce size up to 80%

            val file = File(context.filesDir, filename)

            file.outputStream().use { outputStream ->
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
            }

            val savedImage = SavedImage(imagePath = file.absolutePath)
            savedImageDao.insertImage(savedImage)

            bitmap.recycle()

            Result.success(file.absolutePath)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}