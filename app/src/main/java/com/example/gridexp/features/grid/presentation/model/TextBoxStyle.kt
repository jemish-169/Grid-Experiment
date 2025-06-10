package com.example.gridexp.features.grid.presentation.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridexp.theme.GridAppFontFamily
import com.example.gridexp.theme.*

data class TextBoxStyle(
    val backgroundColor: Color,
    val textColor: Color,
    val fontSize: TextUnit,
    val fontFamily: FontFamily,
    val cornerRadius: Dp,
    val fontWeight: FontWeight,
)

val textStyles = listOf(
    TextBoxStyle(
        backgroundColor = lightPurple,
        textColor = purple,
        fontSize = 16.sp,
        fontFamily = GridAppFontFamily.InterFont,
        cornerRadius = 8.dp,
        fontWeight = FontWeight.Normal
    ),
    TextBoxStyle(
        backgroundColor = lightOrange,
        textColor = orange,
        fontSize = 18.sp,
        fontFamily = GridAppFontFamily.PoppinsFont,
        cornerRadius = 12.dp,
        fontWeight = FontWeight.Medium
    ),
    TextBoxStyle(
        backgroundColor = lightGreen,
        textColor = green,
        fontSize = 14.sp,
        fontFamily = GridAppFontFamily.robotoFont,
        cornerRadius = 16.dp,
        fontWeight = FontWeight.SemiBold
    ),
    TextBoxStyle(
        backgroundColor = lightRed,
        textColor = red,
        fontSize = 20.sp,
        fontFamily = GridAppFontFamily.LatoFont,
        cornerRadius = 4.dp,
        fontWeight = FontWeight.Bold
    ),
    TextBoxStyle(
        backgroundColor = lightYellow,
        textColor = yellow,
        fontSize = 15.sp,
        fontFamily = GridAppFontFamily.OpenSansFont,
        cornerRadius = 20.dp,
        fontWeight = FontWeight.Thin
    ),
    TextBoxStyle(
        backgroundColor = pencilGrey,
        textColor = grey,
        fontSize = 17.sp,
        fontFamily = GridAppFontFamily.InterFont,
        cornerRadius = 6.dp,
        fontWeight = FontWeight.Medium
    ),
    TextBoxStyle(
        backgroundColor = lightSky,
        textColor = sky,
        fontSize = 19.sp,
        fontFamily = GridAppFontFamily.PoppinsFont,
        cornerRadius = 10.dp,
        fontWeight = FontWeight.Bold
    ),
    TextBoxStyle(
        backgroundColor = lightPink,
        textColor = pink,
        fontSize = 13.sp,
        fontFamily = GridAppFontFamily.robotoFont,
        cornerRadius = 14.dp,
        fontWeight = FontWeight.SemiBold
    ),
    TextBoxStyle(
        backgroundColor = lightPurple,
        textColor = purple,
        fontSize = 21.sp,
        fontFamily = GridAppFontFamily.LatoFont,
        cornerRadius = 8.dp,
        fontWeight = FontWeight.Thin
    ),
    TextBoxStyle(
        backgroundColor = lightGreen,
        textColor = green,
        fontSize = 16.sp,
        fontFamily = GridAppFontFamily.OpenSansFont,
        cornerRadius = 18.dp,
        fontWeight = FontWeight.Normal
    ),
    TextBoxStyle(
        backgroundColor = lightRed,
        textColor = red,
        fontSize = 22.sp,
        fontFamily = GridAppFontFamily.LatoFont,
        cornerRadius = 12.dp,
        fontWeight = FontWeight.ExtraLight
    ),
    TextBoxStyle(
        backgroundColor = lightOrange,
        textColor = orange,
        fontSize = 18.sp,
        fontFamily = GridAppFontFamily.LatoFont,
        cornerRadius = 24.dp,
        fontWeight = FontWeight.ExtraBold
    )
)