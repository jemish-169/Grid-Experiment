package com.example.gridexp.features.grid.domain

import androidx.compose.ui.graphics.toArgb
import com.example.gridexp.theme.green
import com.example.gridexp.theme.grey
import com.example.gridexp.theme.lightGreen
import com.example.gridexp.theme.lightGrey
import com.example.gridexp.theme.lightOrange
import com.example.gridexp.theme.lightPink
import com.example.gridexp.theme.lightPurple
import com.example.gridexp.theme.lightRed
import com.example.gridexp.theme.lightSky
import com.example.gridexp.theme.lightYellow
import com.example.gridexp.theme.orange
import com.example.gridexp.theme.pink
import com.example.gridexp.theme.purple
import com.example.gridexp.theme.red
import com.example.gridexp.theme.sky
import com.example.gridexp.theme.yellow

object Utils {
    fun getRandomColorPair(): Pair<Int, Int> {
        return listOf(
            Pair(lightRed.toArgb(), red.toArgb()),
            Pair(lightPink.toArgb(), pink.toArgb()),
            Pair(lightSky.toArgb(), sky.toArgb()),
            Pair(lightGreen.toArgb(), green.toArgb()),
            Pair(lightOrange.toArgb(), orange.toArgb()),
            Pair(lightPurple.toArgb(), purple.toArgb()),
            Pair(lightYellow.toArgb(), yellow.toArgb()),
            Pair(lightGrey.toArgb(), grey.toArgb())
        ).random()
    }
}