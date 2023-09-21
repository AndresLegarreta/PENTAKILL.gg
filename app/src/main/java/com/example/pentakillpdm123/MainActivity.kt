package com.example.pentakillpdm123

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pentakillpdm123.ui.theme.Pentakillpdm123Theme
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pentakillpdm123Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
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
        NavigationHost(navController)
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Pentakillpdm123Theme {
        MainScreen()
    }
}