package com.example.pentakillpdm123

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pentakillpdm123.home.model.LeagueModel
import com.example.pentakillpdm123.home.viewModel.HomeViewModel
import com.example.pentakillpdm123.home.views.HomeMainView
import com.example.pentakillpdm123.home.views.ProfileView
import com.example.pentakillpdm123.login.LoginScreenView
import com.example.pentakillpdm123.login.PreferencesManager
import com.example.pentakillpdm123.login.RegisterScreenView
import com.example.pentakillpdm123.login.network.LoginViewModel
import com.example.pentakillpdm123.login.register.RegisterViewModel
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.onboarding.SplashScreen
import com.example.pentakillpdm123.positionchamp.PositionChamp
import com.example.pentakillpdm123.ui.theme.Pentakillpdm123Theme

import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @SuppressLint("UnsafeOptInUsageError")
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pentakillpdm123Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                )
                {
                    val navController = rememberNavController()

                    Surface(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        NavigationHost(navController)
                    }
                }
            }
        }
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavigationHost(navController = navController)

}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationHost(navController: NavHostController) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val alreadyShowOnboarding = remember { mutableStateOf(preferencesManager.getData("alreadyShowOnboarding", false)) }

    NavHost(navController, startDestination = NavRoutes.SplashView.route) {
        composable(NavRoutes.onboarding.route) {
            OnBoardingView(navController)
        }
        composable(NavRoutes.homemainview.route) {
            HomeMainView(navController, HomeViewModel())
        }
        composable(NavRoutes.positionchamps.route) {
            PositionChamp(navController)
        }
        composable(NavRoutes.login.route) {
            LoginScreenView(navController, LoginViewModel())
        }
        composable(NavRoutes.news.route) {
            Text(text = "Noticias")
        }
        composable(NavRoutes.register.route) {
            RegisterScreenView(navController, RegisterViewModel())
        }
        composable(NavRoutes.SplashView.route) {
            SplashScreen(navController = navController)
        }
        composable(NavRoutes.profile.route) {
            ProfileView(navController = navController, context)
        }
    }

    // Después de mostrar el SplashScreen, decide a dónde navegar
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
}


    @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pentakillpdm123Theme {
    }
}