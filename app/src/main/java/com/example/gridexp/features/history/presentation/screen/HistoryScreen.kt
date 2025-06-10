package com.example.gridexp.features.history.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gridexp.R
import com.example.gridexp.common.presentation.HeaderBackIcon

@Composable
fun HistoryScreen(onBackClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp)
    ) {
        HeaderBackIcon(
            headerText = stringResource(R.string.history),
            onBackClick = onBackClick
        )

        Text(text = stringResource(R.string.history))
    }
}