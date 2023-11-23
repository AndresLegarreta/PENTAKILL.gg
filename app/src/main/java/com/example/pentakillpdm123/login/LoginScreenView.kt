package com.example.pentakillpdm123.login

import android.widget.Toast
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
import com.example.pentakillpdm123.login.model.LoginDataBody
import com.example.pentakillpdm123.login.network.LoginViewModel
import com.example.pentakillpdm123.navigation.NavRoutes

@Composable
fun LoginScreenView(navController: NavController, viewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginResponse by viewModel.loginResponse.observeAsState()
    val isLoginSuccessful by viewModel.isLoginSuccessful.observeAsState()
    val context = LocalContext.current
    val loginAttempted by viewModel.loginAttempted.observeAsState()
    var showErrorDialog by remember { mutableStateOf(false) }

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
        Image(
            painter = painterResource(id = R.drawable.jarvan),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

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
                color = Color.White
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = stringResource(id = R.string.username),
                fontSize = 18.sp,
                color = Color.White
            )
            BasicTextField(
                value = username,
                onValueChange = { username = it },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { /* Handle "Next" action if needed */ }
                ),
                modifier = Modifier
                    .width(250.dp)
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .padding(10.dp)
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
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle "Done" action if needed */ }
                ),
                modifier = Modifier
                    .width(250.dp)
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .padding(10.dp)
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
        }
    }
}



