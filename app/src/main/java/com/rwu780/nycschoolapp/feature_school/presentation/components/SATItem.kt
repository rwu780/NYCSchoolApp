package com.rwu780.nycschoolapp.feature_school.presentation.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rwu780.nycschoolapp.feature_school.domain.model.SAT
import com.rwu780.nycschoolapp.ui.theme.NYCSchoolAppTheme

@Composable
fun SATItem(
    sat: SAT,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {

            var expanded by remember { mutableStateOf(false) }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = sat.school_name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector =
                            if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = ""
                    )
                }
            }
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "# of SAT Test Taker: ${sat.num_of_sat_taker}",
                        style = MaterialTheme.typography.subtitle1
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        SATSubCategory(category = "Reading", score = sat.avg_reading_score)
                        SATSubCategory(category = "Math", score = sat.avg_math_score)
                        SATSubCategory(category = "Writing", score = sat.avg_writing_score)
                    }
                }
            }
        }

    }

}

@Composable
fun SATSubCategory(
    category: String,
    score: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = category, style = MaterialTheme.typography.body1)
        Text(text = "(avg)")

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "$score", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun PreviewSATItem() {
    NYCSchoolAppTheme {
        SATItem(
            sat = SAT(
                dbn = "02M392",
                school_name = "URBAN ASSEMBLY SCHOOL OF BUSINESS FOR YOUNG WOMEN, THE",
                num_of_sat_taker = 42,
                avg_reading_score = 373,
                avg_math_score = 370,
                avg_writing_score = 384
            )
        )
    }

}