package com.leinaro.tasktamer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.leinaro.tasktamer.ui.theme.TaskTamerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTamerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    val activities = remember {
        mutableStateListOf<Activity>()
    }
    val currentBackStateEntry by navController.currentBackStackEntryAsState()


    /*Activity(
                    id = "1",
                    name = "Tarea 1",
                    location = "Casa - 50 mts",
                    description = "Obten 20 puntos por completar esta tarea",
                    priority = 1,
                ),
                Activity(
                    id = "2",
                    name = "Tarea 1",
                    location = "Casa - 50 mts",
                    description = "Obten 20 puntos por completar esta tarea",
                    priority = 1,
                ),*/

    var title by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            MainTopBar(
                navController = navController,
                title = title,
            )
        },
        floatingActionButton = {
            if (currentBackStateEntry?.destination?.route == Routes.ActivitiesList.route){
                CreateActivityButton(
                    onClick = {
                        Log.e("iarl", "Create activity")
                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea 1",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))
                       // navController.navigate(Routes.CreateActivity.route)
                    }
                )
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = Routes.ActivitiesList.route
        ) {
            composable(Routes.ActivitiesList.route) {
                title = "Task Tamer"
                ActivitiesListScreen(
                    modifier = Modifier.padding(paddingValues),
                    navController = navController,
                    activities = activities
                )
            }

            composable(Routes.Login.route){

            }
            composable(Routes.PasswordRecover.route){

            }
            composable(Routes.CodeVerify.route){

            }
            composable(Routes.CreateActivity.route){

            }
            composable(Routes.Register.route){

            }
            composable(Routes.Profile.route){
                Profile(
                    modifier = Modifier.padding(paddingValues),
                    navController = navController
                )
            }


            dialog(Routes.Info.route) {
                InfoScreen(listOf(
                    Developer("Jesus Rios", "jd.rios2@uniandes.edu.co", "https://github.com/darios07"),
                    Developer("Inés Rojas", "ia.rojas2@uniandes.edu.co", "https://github.com/leinaro")
                ))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    TaskTamerTheme {
        MainScreen()
    }
}


