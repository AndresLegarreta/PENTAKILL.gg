package com.example.pentakillpdm123

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pentakillpdm123.home.views.HomeMainView
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.positionchamp.PositionChamp


@Composable
    fun NavigationHost(navController: NavHostController){

    NavHost(navController = navController, startDestination = NavRoutes.homemainview.route){

        composable(NavRoutes.positionchamps.route){
            PositionChamp(navController = navController)
        }
        composable(NavRoutes.homemainview.route){
            HomeMainView(navController = navController)
        }
<<<<<<< HEAD
        composable(NavRoutes.homemainview.route){
            HomeMainView(navController = navController)
        }
=======


>>>>>>> f408c7f2d483e68974120e1fd93ab79104526a88
    }
}