package com.example.pentakillpdm123.onboarding

import android.preference.PreferenceManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
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
    LaunchedEffect(key1 = "navigation") {
        delay(2000)

        if (alreadyShowOnboarding.value) {
            navController.navigate(NavRoutes.login.route) {
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
    val lottieComposition by rememberLottieComposition (LottieCompositionSpec.RawRes(R.raw.animationpenta))
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.white)),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            lottieComposition,
            modifier = Modifier.size(450.dp)
        )
    }
}


@Preview
@Composable
fun SplashScreenPreview() {


}