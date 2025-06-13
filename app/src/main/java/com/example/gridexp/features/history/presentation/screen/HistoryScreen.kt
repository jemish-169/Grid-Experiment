package com.example.gridexp.features.history.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.gridexp.R
import com.example.gridexp.common.domain.state.AppState
import com.example.gridexp.common.presentation.HeaderBackIcon
import com.example.gridexp.features.history.presentation.components.ImageItem
import com.example.gridexp.features.history.presentation.viewmodel.HistoryViewModel
import com.example.gridexp.features.history.presentation.viewmodel.IHistoryViewModel


@Composable
fun HistoryScreen(
    onBackClick: () -> Unit,
    historyViewModel: IHistoryViewModel = hiltViewModel<HistoryViewModel>()
) {

    val imageListState by historyViewModel.imageListState.collectAsStateWithLifecycle()

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

        LazyColumn(
            modifier = Modifier
                .padding(top = 8.dp)
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            when (imageListState) {
                is AppState.Loading -> {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillParentMaxSize()
                        ) { CircularProgressIndicator() }
                    }
                }

                is AppState.Error -> {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillParentMaxSize()
                        ) {
                            Text(
                                text = (imageListState as AppState.Error<String>).error,
                                textAlign = TextAlign.Center,
                                fontSize = 18.sp,
                                lineHeight = 22.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onSurface,
                                letterSpacing = 0.8.sp
                            )
                        }
                    }
                }

                is AppState.Success -> {
                    val imageList = (imageListState as AppState.Success<List<String>>).message
                    items(items = imageList, key = { it }) { image ->
                        ImageItem(image)
                    }
                }

                else -> {}
            }
        }
    }
}