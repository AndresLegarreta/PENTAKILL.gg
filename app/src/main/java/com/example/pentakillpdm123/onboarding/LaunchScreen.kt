package com.example.pentakillpdm123.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.pentakillpdm123.R
import kotlinx.coroutines.delay

@Composable
fun LaunchScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Puedes mostrar tu logo o un indicador de carga aquí
        Image(painter = painterResource(id = R.drawable.logolol), contentDescription = "Logo")
        CircularProgressIndicator() // Un indicador de carga
    }
    LaunchedEffect(key1 = "navegacion") {
        delay(4000)
        navController.navigate("MainScreen") {
            // Asegúrate de que la navegación hacia atrás no regrese a la pantalla de carga
            popUpTo("SplashView") { inclusive = true }
        }
    }
}


