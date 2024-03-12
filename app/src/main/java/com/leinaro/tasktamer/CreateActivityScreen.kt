package com.leinaro.tasktamer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Outlined
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateActivityScreen(
    modifier: Modifier = Modifier,
    onSaveClick: () -> Unit = {},
) {
    var title by remember { mutableStateOf(TextFieldValue("Tarea")) }
    var fecha by remember { mutableStateOf(TextFieldValue("12 Marzo 2024")) }
    var hora by remember { mutableStateOf(TextFieldValue("10:00 AM")) }
    var lugar by remember { mutableStateOf(TextFieldValue("Casa")) }
    var prioridad by remember { mutableStateOf(TextFieldValue("Normal")) }

    val dateState = rememberDatePickerState()
    val timeState = rememberTimePickerState()
    val openDateDialog = remember { mutableStateOf(false) }
    val openTimeDialog = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.End,
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            label = { Text("Titulo") },
            onValueChange = { title = it },
            placeholder = {
                Text(
                    text = "Titulo",
                    //color = color
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().clickable { openDateDialog.value = true },
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
            modifier = Modifier.fillMaxWidth().clickable { openTimeDialog.value = true },
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FilterChipExample("L")
            FilterChipExample("M")
            FilterChipExample("M")
            FilterChipExample("J")
            FilterChipExample("V")
            FilterChipExample("S")
            FilterChipExample("D")

        }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = lugar,
            label = { Text("Lugar(Opcional)") },
            onValueChange = { lugar = it },
            placeholder = {
                Text(
                    text = "Lugar(Opcional)",
                    //color = color
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = prioridad,
            label = { Text("Prioridad") },
            onValueChange = { prioridad = it },
            placeholder = {
                Text(
                    text = "Prioridad",
                    //color = color
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            )
        )

        Button(
            onClick = {
                onSaveClick()
            }) {
            Text(text = "Guardar")
        }

    }

    if (openDateDialog.value) {
        DatePickerDialog(
            onDismissRequest = {
                openDateDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDateDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openDateDialog.value = false
                    }
                ) {
                    Text("CANCELAR")
                }
            }
        ) {
            DatePicker(
                state = dateState
            )
        }
    }

    if (openTimeDialog.value) {
        DatePickerDialog(
            onDismissRequest = {
                openTimeDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openTimeDialog.value = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        openTimeDialog.value = false
                    }
                ) {
                    Text("CANCELAR")
                }
            }
        ) {
            TimePicker(
                state = timeState
            )
        }
    }

}

@Preview
@Composable
fun CreateActivityScreenPreview() {
    CreateActivityScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipExample(text: String) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(text)
        },
        selected = selected,
    )
}