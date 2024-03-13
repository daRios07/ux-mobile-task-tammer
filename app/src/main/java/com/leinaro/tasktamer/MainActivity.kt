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
    var user by remember {
        mutableStateOf<User?>(null)
    }
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
                user = user,
            )
        },
        floatingActionButton = {
            if (currentBackStateEntry?.destination?.route == Routes.ActivitiesList.route){
                CreateActivityButton(
                    onClick = {
                        navController.navigate(Routes.CreateActivity.route)
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
                Login(
                    modifier = Modifier.padding(paddingValues),
                    onLogin = {
                        user = User(
                            name = "Jesus Adelo",
                            email = "micorreo@uniandes.edu.co",
                        )

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        navController.navigate(Routes.ActivitiesList.route){
                            popUpTo(navController.graph.id){
                                inclusive = true
                            }
                        }

                    },
                    onRegister = {
                        navController.navigate(Routes.Register.route)
                    },
                    onPasswordRecover = {
                        navController.navigate(Routes.PasswordRecover.route)
                    }
                )
            }
            composable(Routes.PasswordRecover.route){
                PasswordRecovery(
                    modifier = Modifier.padding(paddingValues),
                    onRecover = {
                        navController.navigate(Routes.CodeVerify.route)
                    }
                )

            }
            composable(Routes.CodeVerify.route){
                CodeVerify(
                    modifier = Modifier.padding(paddingValues),
                    onRecoery = {
                        user = User(
                            name = "Jesus Adelo",
                            email = "micorreo@uniandes.edu.co",
                        )

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))

                        navController.navigate(Routes.ActivitiesList.route){
                            popUpTo(navController.graph.id){
                                inclusive = true
                            }
                        }
                    }
                )
            }
            composable(Routes.CreateActivity.route){
                CreateActivityScreen(
                    modifier = Modifier.padding(paddingValues),
                    onSaveClick = {
                        activities.add(Activity(
                            id = (activities.size+1).toString(),
                            name = "Tarea ${activities.size+1}",
                            location = "Casa - 50 mts",
                            description = "Obten 20 puntos por completar esta tarea",
                            priority = 1,
                        ))
                        navController.navigateUp()
                    }
                )

            }
            composable(Routes.Register.route){
                Register(
                    modifier = Modifier.padding(paddingValues),
                    onRegister = {
                        user = User(
                            name = "Jesus Adelo",
                            email = "micorreo@uniandes.edu.co",
                        )
                        navController.navigate(Routes.ActivitiesList.route){
                            popUpTo(navController.graph.id){
                                inclusive = true
                            }
                        }
                    }
                )
            }

            composable(Routes.Alarma.route){
                Alarma(
                    modifier = Modifier.padding(paddingValues),
                    onComplete = {
                        navController.navigate(Routes.CompleteActivity.route){
                            popUpTo(Routes.ActivitiesList.route){
                                inclusive = false
                            }
                        }
                    },
                    onPostpone = {
                        navController.navigate(Routes.PosponerActivity.route){
                            popUpTo(Routes.ActivitiesList.route){
                                inclusive = false
                            }
                        }
                    },
                    onDismiss = {
                        navController.navigate(Routes.ActivitiesList.route){
                            popUpTo(navController.graph.id){
                                inclusive = true
                            }
                        }
                    },
                )
            }

            dialog(Routes.CompleteActivity.route){
                CompleteActivity(
                    modifier = Modifier.padding(paddingValues),
                    onCompletarActivityClick = {
                        navController.navigateUp()
                    }
                    )
            }

            dialog(Routes.PosponerActivity.route){
                PosponerActivity(
                    modifier = Modifier.padding(paddingValues),
                    onPosponerActivityClick = {
                        navController.navigateUp()
                    }
                )
            }

            composable(Routes.Profile.route){
                Profile(
                    modifier = Modifier.padding(paddingValues),
                    logout = {
                        user = null
                        navController.navigate(Routes.ActivitiesList.route) {
                            popUpTo(navController.graph.id) {
                                inclusive = true
                            }
                        }
                    }
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


