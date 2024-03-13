package com.leinaro.tasktamer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.leinaro.tasktamer.R.drawable

@Composable
fun CodeVerify(
    modifier: Modifier,
    onRecoery: () -> Unit = {},
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text ="Recuperar contraseña",
            style = MaterialTheme.typography.titleLarge,)

        Text(text ="Te enviamos un correo con el código de recuperación, escribelo junto con una nueva contraseña y podras ingresar nuevamente.",
            style = MaterialTheme.typography.labelLarge,)

        var codigo by remember { mutableStateOf(TextFieldValue("123456")) }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = codigo,
            label = { Text("Codigo") },
            onValueChange = { codigo = it },
            placeholder = {
                Text(
                    text = "codigo",
                    //color = color
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            )
        )

        var pass by remember { mutableStateOf(TextFieldValue("123456")) }


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = pass,
            label = { Text("Nueva contraseña") },
            onValueChange = { pass = it },
            placeholder = {
                Text(
                    text = "Nueva contraseña",
                    //color = color
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            ),
            visualTransformation = PasswordVisualTransformation(),

            )

        var passConfirm by remember { mutableStateOf(TextFieldValue("123456")) }


        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = passConfirm,
            label = { Text("Confirmar contraseña") },
            onValueChange = { passConfirm = it },
            placeholder = {
                Text(
                    text = "Confirmar contraseña",
                    //color = color
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFF07001),
            ),
            visualTransformation = PasswordVisualTransformation(),

            )

        Button(
            onClick = {
                onRecoery()
            }) {
            Text(text = "Recuperar")
        }
    }
}

@Preview
@Composable
fun CodeVerifyPreview() {
    CodeVerify(modifier = Modifier)
}
