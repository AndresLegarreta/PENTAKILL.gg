package com.example.pentakillpdm123.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pentakillpdm123.R
import com.example.pentakillpdm123.navigation.NavRoutes

@Composable
fun LoginScreenView(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
                text = "Login",
                fontSize = 24.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

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

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate(NavRoutes.positionchamps.route)
                },
                modifier = Modifier.width(120.dp),
            ) {
                Text("Continue")
            }
        }
    }
}

