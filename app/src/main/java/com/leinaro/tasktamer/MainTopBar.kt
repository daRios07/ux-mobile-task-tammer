package com.leinaro.tasktamer

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.leinaro.tasktamer.ui.theme.TaskTamerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    navController: NavController = rememberNavController(),
    title: String,
    user: User? = null,
) {
    val currentBackStateEntry by navController.currentBackStackEntryAsState()
    val color = Color.White
    var expanded by remember { mutableStateOf(false) }
    var thereIsPreviousEntry by remember { mutableStateOf(false) }

    LaunchedEffect(currentBackStateEntry){
        thereIsPreviousEntry = navController.previousBackStackEntry != null
        if (navController.previousBackStackEntry == null){
            Log.e("iarl", "navController.previousBackStackEntry: ${navController.previousBackStackEntry}")
        }
    }

    if (currentBackStateEntry?.destination?.route == Routes.Alarma.route){
        Log.e("iarl", "currentBackStateEntry: ${currentBackStateEntry}")
    } else {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    title,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontSize = 16.sp,
                        //fontFamily = FontFamily(Font(font.oswald)),
                        fontWeight = FontWeight(500),
                    ),
                    color = color
                )
            },
            navigationIcon =  {
                if(thereIsPreviousEntry) {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = color
                        )
                    }
                }
            },
            actions = {
                IconButton(onClick = {
                    if (user == null){
                        navController.navigate(Routes.Login.route)
                    } else {
                        navController.navigate(Routes.Profile.route)
                    }
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Person,
                        contentDescription = "Localized description",
                        tint = color
                    )
                }

                IconButton(onClick = {
                    expanded = !expanded
                }) {
                    Icon(
                        imageVector = Filled.MoreVert,
                        contentDescription = "Localized description",
                        tint = color
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {

                    DropdownMenuItem(
                        text = { Text("Simular Alarma") },
                        onClick = {
                            navController.navigate(Routes.Alarma.route)
                            expanded = false
                        }
                    )
                    DropdownMenuItem(
                        text = { Text("Sobre Task Tamer") },
                        onClick = {
                            navController.navigate(Routes.Info.route)
                            expanded = false
                        },
                        leadingIcon = {
                            Icon(
                                Icons.Outlined.Info,
                                contentDescription = null
                            )
                        })
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
            )
        )
    }


}

@Composable
@Preview
fun MainTopBarPreview(){
    TaskTamerTheme {
        MainTopBar(title = "Task Tamer")
    }
}

@Composable
fun CreateActivityButton(
    onClick: () -> Unit = {},
){
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { onClick() },
    ) {
        Icon(Filled.Add, "Floating action button.")
    }
}

@Composable
@Preview
fun CreateActivityButtonPreview(){
    TaskTamerTheme {
        CreateActivityButton()
    }
}