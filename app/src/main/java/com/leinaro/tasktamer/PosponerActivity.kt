package com.leinaro.tasktamer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leinaro.tasktamer.R.drawable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PosponerActivity(
    modifier: Modifier = Modifier,
    onPosponerActivityClick: () -> Unit = {}
) {
    var fecha by remember { mutableStateOf(TextFieldValue("12 Marzo 2024")) }
    var hora by remember { mutableStateOf(TextFieldValue("10:00 AM")) }
    val dateState = rememberDatePickerState()
    val timeState = rememberTimePickerState()
    val openDateDialog = remember { mutableStateOf(false) }
    val openTimeDialog = remember { mutableStateOf(false) }

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
            text = "Posponer actividad",
            style = MaterialTheme.typography.titleLarge,
        )
        Text(
            text = "Podemos ser flexibles con los tiempos, selecciona para cuando planeas realizar y completar esta actividad.",
            style = MaterialTheme.typography.labelLarge,
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { openDateDialog.value = true },
            value = fecha,
            label = { Text("Fecha") },
            onValueChange = { fecha = it },
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = { openDateDialog.value = true }) {
                    Icon(
                        imageVector = Outlined.DateRange,
                        contentDescription = "calendario",
                        modifier = Modifier.clickable { openDateDialog.value = true }
                        //tint = Color(0xFFF07001)
                    )
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { openTimeDialog.value = true },
            value = hora,
            readOnly = true,
            label = { Text("Hora") },
            onValueChange = { hora = it },
            trailingIcon = {
                IconButton(onClick = { openTimeDialog.value = true }) {
                    Icon(
                        imageVector = Outlined.DateRange,
                        contentDescription = "calendario",
                        modifier = Modifier.clickable { openTimeDialog.value = true }
                        //tint = Color(0xFFF07001)
                    )
                }
            },
            placeholder = {
                Text(
                    text = "Hora",
                    modifier = Modifier.clickable { openTimeDialog.value = true }
                    //color = color
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            )
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

        Button(onClick = {onPosponerActivityClick()}) {
            Text(text ="Posponer actividad")
        }
    }
}

@Preview
@Composable
fun PosponerActivityPreview() {
    PosponerActivity()
}