package com.leinaro.tasktamer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun Login(
    modifier: Modifier,
    onLogin: () -> Unit = {},
    onRegister: () -> Unit = {},
    onPasswordRecover: () -> Unit = {},
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.Top),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = drawable.logo), contentDescription = "empty image")

        var correo by remember { mutableStateOf(TextFieldValue("micorreo@uniades.edu.co")) }

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = correo,
            label = { Text("Correo") },
            onValueChange = { correo = it },
            placeholder = {
                Text(
                    text = "correo",
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
            label = { Text("Contraseña") },
            onValueChange = { pass = it },
            placeholder = {
                Text(
                    text = "Contraseña",
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
                onLogin()
            }) {
            Text(text = "Iniciar Sesión")
        }

        TextButton(onClick = { onRegister() }) {
            Text(text = "Registro",
                color = Color(0xFF000000))
        }

        TextButton(onClick = { onPasswordRecover() }) {
            Text(text = "Recuperar contraseña",
                color = Color(0xFF000000)
            )
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    Login(modifier = Modifier)
}
