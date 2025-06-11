package com.example.gridexp.features.grid.presentation

import androidx.activity.ComponentActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.filter
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import com.example.gridexp.features.grid.presentation.screen.GridScreen
import org.junit.Rule
import org.junit.Test

class GridScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule<ComponentActivity>()

    private val mockGridViewModel = MockGridViewModel()

    @Test
    fun grid_displays_correct_number_of_items() {
        composeRule.setContent {
            MaterialTheme {
                GridScreen(
                    onBackClick = {},
                    gridViewModel = mockGridViewModel
                )
            }
        }

        composeRule
            .onAllNodesWithTag("gridItem")
            .assertCountEquals(mockGridViewModel.textList.size)
    }

    @Test
    fun entering_text_updates_all_grid_cells() {
        val newText = "Hello"

        composeRule.setContent {
            MaterialTheme {
                GridScreen(
                    onBackClick = {},
                    gridViewModel = mockGridViewModel
                )
            }
        }

        composeRule.onNodeWithTag("inputTextField").apply {
            performTextClearance()
            performTextInput(newText)
        }

        composeRule
            .onAllNodesWithTag("gridItem")
            .assertCountEquals(mockGridViewModel.textList.size)

        composeRule
            .onAllNodesWithText(newText)
            .filter(hasTestTag("gridItem"))
            .assertCountEquals(mockGridViewModel.textList.size)
    }

    @Test
    fun grid_displays_initial_text() {
        composeRule.setContent {
            MaterialTheme {
                GridScreen(
                    onBackClick = {},
                    gridViewModel = mockGridViewModel
                )
            }
        }

        val initialText = mockGridViewModel.inputText.value

        composeRule
            .onAllNodesWithText(initialText)
            .filter(hasTestTag("gridItem"))
            .assertCountEquals(mockGridViewModel.textList.size)
    }
}
