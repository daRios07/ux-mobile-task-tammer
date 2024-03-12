package com.leinaro.tasktamer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.leinaro.tasktamer.ui.theme.TaskTamerTheme

data class Activity(
    val id: String,
    val name: String,
    val description: String,
    val location: String,
    val priority: Int,
)


@Composable
fun ActivitiesListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    activities: List<Activity>
) {
    if (activities.isEmpty()) {
        ActivitiesEmptyList()
    } else {
        ActivitiesList(
            modifier = modifier,
            activities = activities,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivitiesListScreenPreview() {
    TaskTamerTheme {
        ActivitiesListScreen(activities = emptyList())
    }
}

@Composable
fun ActivitiesEmptyList(
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = R.drawable.empty_list), contentDescription = "empty image")
        Text(
            text = "No tienes actividades",
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Agrega una actividad y la mostraremos aquí.",
            style = MaterialTheme.typography.labelLarge,
            color = Color(0xFF49454F)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActivitiesEmptyListPreview() {
    TaskTamerTheme {
        ActivitiesEmptyList()
    }
}


@Composable
fun ActivitiesList(
    modifier: Modifier = Modifier,
    activities: List<Activity>,
){
    LazyColumn(
        modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ){
        item {
            Text(
                text = "Próximas actividades",
                style = MaterialTheme.typography.titleLarge,
            )
        }
        items(items=activities, key = {activity -> activity.id}){
            ListItem(
                colors = ListItemDefaults.colors(containerColor = Color(0xFFF3EDF7)),
                headlineContent = { Text(text = it.name) },
                supportingContent = {
                    Column {
                        Text(text = it.location)
                        Text(text = it.description)
                    }
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivitiesListPreview() {
    TaskTamerTheme {
        ActivitiesList(
            activities = listOf(
                Activity(
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
                ),
            )
        )
    }
}









