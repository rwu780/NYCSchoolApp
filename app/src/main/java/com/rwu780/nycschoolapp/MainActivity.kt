package com.rwu780.nycschoolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.rwu780.nycschoolapp.feature_school.presentation.SATScreen
import com.rwu780.nycschoolapp.ui.theme.NYCSchoolAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NYCSchoolAppTheme {
                SATScreen()
            }
        }
    }
}
