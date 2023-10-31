package com.example.pentakillpdm123

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pentakillpdm123.home.views.HomeMainView
import com.example.pentakillpdm123.login.LoginScreenView
import com.example.pentakillpdm123.login.PreferencesManager
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.positionchamp.PositionChamp
import com.example.pentakillpdm123.ui.theme.Pentakillpdm123Theme

import com.google.accompanist.pager.ExperimentalPagerApi

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
    val navController = rememberNavController()
    val alreadyShowOnboarding = remember { mutableStateOf(preferencesManager.getData("alreadyShowOnboarding",false))}
        NavHost(
            navController, startDestination = if (!alreadyShowOnboarding.value) {
            NavRoutes.onboarding.route
        }else{
            NavRoutes.login.route
        }
        ){
            composable(NavRoutes.onboarding.route) {
                OnBoardingView(navController)
            }
            composable(NavRoutes.homemainview.route) {
                HomeMainView(navController)
            }
            composable(NavRoutes.positionchamps.route) {
                PositionChamp(navController)
            }
            composable(NavRoutes.login.route) {
                LoginScreenView(navController)
            }

            composable(NavRoutes.news.route) {
                Text(text = "Noticias")
            }
        }
    }

    @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pentakillpdm123Theme {
    }
}