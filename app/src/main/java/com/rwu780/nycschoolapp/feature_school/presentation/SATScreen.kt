package com.rwu780.nycschoolapp.feature_school.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rwu780.nycschoolapp.feature_school.presentation.components.SATItem

@Composable
fun SATScreen(
    viewModel: SATViewModel = hiltViewModel()
) {

    val state = viewModel.state

    LazyColumn() {
        items(state.value){ item ->
            SATItem(sat = item)
            Spacer(modifier = Modifier.height(8.dp))

        }
    }

}