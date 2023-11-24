package com.example.pentakillpdm123.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.pentakillpdm123.R
import com.example.pentakillpdm123.login.PreferencesManager
import kotlinx.coroutines.delay

@Composable
fun LaunchScreen(navController: NavController) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    preferencesManager.saveData("alreadyShowOnboarding", true)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logolol), contentDescription = "Logo")
        CircularProgressIndicator() // Un indicador de carga
    }

    LaunchedEffect(key1 = Unit) {
        delay(4000)
        navController.navigate("loginscreenview") {
            popUpTo("launchscreen") { inclusive = true }
        }
    }
}