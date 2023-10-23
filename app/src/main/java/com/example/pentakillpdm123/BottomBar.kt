package com.example.pentakillpdm123

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.pentakillpdm123.ui.theme.Pentakillpdm123Theme
import androidx.navigation.compose.rememberNavController
import com.example.pentakillpdm123.home.views.HomeMainView
import com.example.pentakillpdm123.navigation.BarItems
import com.google.accompanist.pager.ExperimentalPagerApi


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pentakillpdm123Theme {
                // A surface container using the 'background' color from the theme
                OnBoardingView()

            }
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BottomBarScreen() {
    val navController = rememberNavController()

    val navItems = listOf(
        BarItems.Home,
        BarItems.News,
        BarItems.Stream,
        BarItems.Social,
        BarItems.Profile

    )
    Scaffold(bottomBar = { BottomNavigation(navController = navController, items = navItems) }
    ){
        NavigationHost(navController = navController)
    }
}



@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pentakillpdm123Theme {

    }
}