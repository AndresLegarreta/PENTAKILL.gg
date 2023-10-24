package com.example.pentakillpdm123

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.pentakillpdm123.navigation.BarItems
import com.google.accompanist.pager.ExperimentalPagerApi


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



