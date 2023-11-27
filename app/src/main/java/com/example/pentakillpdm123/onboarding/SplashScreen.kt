package com.example.pentakillpdm123.onboarding

import android.preference.PreferenceManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pentakillpdm123.R
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.login.PreferencesManager
import kotlinx.coroutines.delay


@Composable

fun SplashScreen(navController: NavController) {
    val context = LocalContext.current

    val preferenceManager = remember { PreferencesManager(context) }

    val alreadyShowOnboarding = remember {
        mutableStateOf(preferenceManager.getData("alreadyShowOnboarding",false))
    }
    LaunchedEffect(key1 = "navegacion") {
        delay(1000)

        if (alreadyShowOnboarding.value) {
            navController.navigate(NavRoutes.register.route) {
                popUpTo(NavRoutes.SplashView.route) {
                    inclusive = true
                }
            }
        } else {
            navController.navigate(NavRoutes.onboarding.route) {
                popUpTo(NavRoutes.SplashView.route) {
                    inclusive = true
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.secondary)// Fondo azul claro
            .padding(top = 200.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logolol),
            contentDescription = "Imagen del logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

    }
}


@Preview
@Composable
fun SplashScreenPreview() {

    SplashScreen(navController = rememberNavController())

}