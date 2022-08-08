package com.rwu780.nycschoolapp.feature_school.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rwu780.nycschoolapp.feature_school.presentation.components.SATItem

@Composable
fun SATScreen(
    onNavigate: (String) -> Unit,
    viewModel: SATViewModel = hiltViewModel()
) {

    val state = viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "NYC School SAT Scores")
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(state.value) { item ->
                SATItem(sat = item, onNavigate = onNavigate)
                Spacer(modifier = Modifier.height(8.dp))

            }
        }
    }
}