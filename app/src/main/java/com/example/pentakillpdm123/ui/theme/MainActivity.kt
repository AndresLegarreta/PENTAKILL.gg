package com.example.pentakillpdm123.ui.theme
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pentakillpdm123.home.views.HomeMainView
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.positionchamp.PositionChamp

import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pentakillpdm123Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavigationHost(navController = navController) }

@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = NavRoutes.homemainview.route) {
        composable(NavRoutes.homemainview.route) {
            HomeMainView(navController = navController)
        }
        composable(NavRoutes.positionchamps.route) {
            PositionChamp(navController = navController)
        }

        // Puedes agregar más composables aquí para otras pantallas
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pentakillpdm123Theme {
        MainScreen()
    }
}