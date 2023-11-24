package com.example.pentakillpdm123.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ContentAlpha
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.pentakillpdm123.navigation.NavRoutes
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.livedata.observeAsState

import com.example.pentakillpdm123.login.model.LoginDataBody
import com.example.pentakillpdm123.login.network.LoginViewModel

@Composable
fun LoginScreenView(navController: NavController, viewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginResponse by viewModel.loginResponse.observeAsState()
    val isLoginSuccessful by viewModel.isLoginSuccessful.observeAsState()
    val context = LocalContext.current
    val loginAttempted by viewModel.loginAttempted.observeAsState()
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

    LaunchedEffect(isLoginSuccessful, loginAttempted) {
        if (loginAttempted == true) {
            if (isLoginSuccessful == true) {
                showErrorDialog = false
                navController.navigate(NavRoutes.positionchamps.route) {
                    popUpTo(NavRoutes.positionchamps.route) { inclusive = true }
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
            text = { Text("Error al inciar sesion") },
            confirmButton = {
                Button(
                    onClick = { showErrorDialog = false }
                ) {
                    Text("Aceptar")
                }
            }
        )
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.login),
                fontSize = 24.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(48.dp))

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
                    viewModel.doLogin(
                        loginData = LoginDataBody(
                            us = username, pass = password
                        )
                    )

                },
                modifier = Modifier.width(120.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.contine),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navController.navigate(NavRoutes.register.route) },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(Color.Black)
            ) {
                Text(
                    text = stringResource(id = R.string.registeryet),
                    modifier = Modifier.padding(vertical = 5.dp, horizontal = 5.dp),
                    color = Color.White,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge)

            }
        }
    }
}



