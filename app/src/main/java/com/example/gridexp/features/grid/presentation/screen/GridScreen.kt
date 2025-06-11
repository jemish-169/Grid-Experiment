package com.example.gridexp.features.grid.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gridexp.R
import com.example.gridexp.common.presentation.HeaderBackIcon
import com.example.gridexp.features.grid.presentation.components.GridCellTextBox
import com.example.gridexp.features.grid.presentation.viewmodel.GridViewModel
import com.example.gridexp.features.grid.presentation.viewmodel.IGridViewModel

@Composable
fun GridScreen(
    onBackClick: () -> Unit,
    gridViewModel: IGridViewModel = hiltViewModel<GridViewModel>()
) {
    val inputText by gridViewModel.inputText.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp)
    ) {
        HeaderBackIcon(
            headerText = stringResource(R.string.grid),
            onBackClick = onBackClick
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(items = gridViewModel.textList, key = { index -> index }) { index ->
                GridCellTextBox(text = inputText, styleIndex = index)
            }
        }
        OutlinedTextField(
            value = inputText,
            onValueChange = { gridViewModel.onInputChange(it) },
            label = { Text(text = stringResource(R.string.input_text)) },
            singleLine = true,
            modifier = Modifier
                .testTag("inputTextField")
                .padding(top = 16.dp)
                .fillMaxWidth()
                .focusRequester(remember { FocusRequester() })
        )
    }
}