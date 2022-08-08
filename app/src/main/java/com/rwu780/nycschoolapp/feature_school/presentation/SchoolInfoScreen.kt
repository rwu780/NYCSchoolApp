package com.rwu780.nycschoolapp.feature_school.presentation


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SchoolInfoScreen(
    viewModel: SchoolInfoViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
    onNavigateBack: () -> Unit,
) {

    val schoolInfo = viewModel.schoolInfo

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "School Info") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "")
                    }
                }
            )
        }

    ) {
        if (schoolInfo == null){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Unable to find school info", style = MaterialTheme.typography.h6)
            }
            return@Scaffold
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = schoolInfo.school_name, style = MaterialTheme.typography.h6)
            Divider()
            Text(text = schoolInfo.overview_paragraph, style = MaterialTheme.typography.body2)
            Divider()
            Text(text = schoolInfo.location, style = MaterialTheme.typography.h6)
            Divider()
            Text(text = schoolInfo.phone_number, style = MaterialTheme.typography.h6)
            Divider()
            Text(text = schoolInfo.website, style = MaterialTheme.typography.h6)
            Divider()
        }
    }
}
