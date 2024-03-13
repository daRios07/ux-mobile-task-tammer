package com.leinaro.tasktamer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leinaro.tasktamer.R.drawable

@Composable
fun CompleteActivity(
    modifier: Modifier = Modifier,
    onCompletarActivityClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxWidth()
            .paint(
                painterResource(id = drawable.background),
                contentScale = ContentScale.FillBounds
            )
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "¡Felicitaciones!",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Ganaste 20 puntos por completar esta tarea Tarea 1 ",
            style = MaterialTheme.typography.labelLarge,
        )
        Text(
            text = "Clasificación",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Estas en el puesto 205, continua completando tareas para subir en la clasificación.",
            style = MaterialTheme.typography.labelLarge,
        )

        Image(
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth,
            painter = painterResource(id = drawable.medalla), contentDescription = "empty image")

        Text(
            text = "Siguientes objetivos",
            style = MaterialTheme.typography.titleLarge,
        )
        LazyRow {
            for (i in 1..5) {
                item {
                    Column(
                        modifier = Modifier.width(100.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            modifier = Modifier.padding(8.dp),
                            painter = painterResource(id = drawable.trofeo),
                            contentDescription = "empty image"
                        )

                        Text(
                            modifier = modifier.align(Alignment.CenterHorizontally),
                            textAlign = TextAlign.Center,
                            text = "No pospongas tus tareas nivel $i",
                            style = MaterialTheme.typography.labelSmall,
                        )
                    }
                }
            }

        }


        Button(onClick = {onCompletarActivityClick()}) {
            Text(text ="Ok")
        }
    }
}

@Preview
@Composable
fun CompleteActivityPreview() {
    CompleteActivity()
}