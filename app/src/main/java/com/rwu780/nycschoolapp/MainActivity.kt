package com.rwu780.nycschoolapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.rwu780.nycschoolapp.feature_school.presentation.SATScreen
import com.rwu780.nycschoolapp.feature_school.presentation.SchoolInfoScreen
import com.rwu780.nycschoolapp.ui.theme.NYCSchoolAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NYCSchoolAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App(
    modifier: Modifier = Modifier
) {

    val controller = rememberNavController()

    NavHost(
        navController = controller,
        startDestination = Screen.SchoolSAT.route,
        modifier = modifier
    ) {
        composable(route = Screen.SchoolSAT.route) {
            SATScreen(
                onNavigate = { dbn ->
                    controller.navigate(Screen.SchoolInfo.createRoute(dbn))
                }
            )
        }

        composable(
            route = Screen.SchoolInfo.route,
            arguments = listOf(
                navArgument(
                    name="dbn"
                ) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) {
            SchoolInfoScreen(
                onNavigateBack = {
                    controller.popBackStack()
                },
            )
        }
    }
}

sealed class Screen(val route: String) {
    object SchoolSAT : Screen("school_sat")
    object SchoolInfo : Screen("school_info?dbn={dbn}") {
        fun createRoute(dbn: String) = "school_info?dbn=$dbn"
    }
}
