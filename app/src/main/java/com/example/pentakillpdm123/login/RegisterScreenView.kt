package com.example.pentakillpdm123.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AlertDialog
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
    var passwordVisibility by remember { mutableStateOf(false) }


    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        textColor = Color.Black,
        cursorColor = Color.Black,
        focusedBorderColor = Color.Black,
        unfocusedBorderColor = Color.Black.copy(alpha = ContentAlpha.disabled),
        focusedLabelColor = Color.Black,
        unfocusedLabelColor = Color.Black.copy(alpha = ContentAlpha.medium)
    )

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
                text = stringResource(id = R.string.register),
                fontSize = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(48.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                label = { Text(stringResource(id = R.string.email), color = Color.Black) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = stringResource(id = R.string.email),
                        tint = Color.Black  // Establece el color del ícono aquí
                    )
                },
                singleLine = true,
                colors = textFieldColors,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { /* Handle "Next" action if needed */ }),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))



            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(stringResource(id = R.string.username), color = Color.Black) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = stringResource(id = R.string.username),
                        tint = Color.Black  // Establece el color del ícono aquí
                    )
                },
                singleLine = true,
                colors = textFieldColors,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onNext = { /* Handle "Next" action if needed */ }),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))


            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(stringResource(id = R.string.password), color = Color.Black) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = stringResource(id = R.string.password),
                        tint = Color.Black  // Establece el color del ícono aquí
                    )
                },
                trailingIcon = {
                    val image = if (passwordVisibility)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff

                    IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                        Icon(
                            imageVector = image,
                            contentDescription = "Toggle password visibility",
                            tint = Color.Black  // Establece el color del ícono aquí
                        )
                    }
                },
                singleLine = true,
                colors = textFieldColors,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { /* Handle "Done" action if needed */ }),
                visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(36.dp))


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
