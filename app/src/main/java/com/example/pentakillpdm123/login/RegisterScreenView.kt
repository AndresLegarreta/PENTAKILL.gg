package com.example.pentakillpdm123.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pentakillpdm123.R
import com.example.pentakillpdm123.login.model.RegisterDataBody
import com.example.pentakillpdm123.login.register.RegisterViewModel
import com.example.pentakillpdm123.navigation.NavRoutes


@Composable
fun RegisterScreenView(navController: NavController, viewModel: RegisterViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    val registerResponse by viewModel.registerResponse.observeAsState()
    val isRegisterSuccessful by viewModel.isRegisterSuccessful.observeAsState()
    val context = LocalContext.current
    val registerAttempted by viewModel.registerAttempted.observeAsState()
    var showErrorDialog by remember { mutableStateOf(false) }

    LaunchedEffect(isRegisterSuccessful, registerAttempted) {
        if (registerAttempted == true) {
            if (isRegisterSuccessful == true) {
                showErrorDialog = false
                navController.navigate(NavRoutes.login.route) {
                    popUpTo(NavRoutes.login.route) { inclusive = true }
                }
            } else {
                showErrorDialog = true
            }
        } else {
            showErrorDialog = false
        }
    }

    if (showErrorDialog) {
        AlertDialog(
            onDismissRequest = { showErrorDialog = false },
            title = { Text("Error") },
            text = { Text("Error al registrarse") },
            confirmButton = {
                Button(
                    onClick = { showErrorDialog = false }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }

    // Layout similar al de LoginScreenView, pero con un campo adicional para el correo electrónico
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // El contenido de la Box, como la imagen y el Column, se mantiene similar
        // ...

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.username),
                fontSize = 18.sp,
                color = Color.White
            )
            BasicTextField(
                value = username,
                onValueChange = { username = it },

                )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.password),
                fontSize = 18.sp,
                color = Color.White
            )
            BasicTextField(
                value = password,
                onValueChange = { password = it },
                // Configuraciones adicionales del TextField
                // ...
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.email),
                fontSize = 18.sp,
                color = Color.White
            )
            BasicTextField(
                value = correo,
                onValueChange = { correo = it },
                // Configuraciones adicionales del TextField
                // ...
            )











                Button(
                onClick = {
                    viewModel.doRegister(
                        registerData = RegisterDataBody(
                            us = username, pass = password, correo = correo
                        )
                    )
                },
                modifier = Modifier.width(120.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                )
            }
        }
    }
}
