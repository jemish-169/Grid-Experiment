package com.example.gridexp.features.grid.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.gridexp.features.grid.presentation.model.textStyles

@Composable
fun GridCellTextBox(
    text: String,
    styleIndex: Int
) {
    val style = remember(styleIndex) { textStyles[styleIndex] }

    val boxModifier = remember(style) {
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                color = style.backgroundColor,
                shape = RoundedCornerShape(style.cornerRadius)
            )
            .border(
                border = style.borderStroke,
                shape = RoundedCornerShape(style.cornerRadius)
            )
            .padding(12.dp)
    }

    Box(
        modifier = boxModifier,
        contentAlignment = Alignment.Center
    ) {
        val textStyle = remember(style) {
            TextStyle(
                fontSize = style.fontSize,
                fontFamily = style.fontFamily,
                color = style.textColor,
                textAlign = TextAlign.Center,
                fontWeight = style.fontWeight
            )
        }

        Text(
            text = text,
            style = textStyle,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .testTag("gridItem")
        )
    }
}