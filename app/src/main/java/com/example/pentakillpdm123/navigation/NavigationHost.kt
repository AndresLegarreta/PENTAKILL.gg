package com.example.pentakillpdm123

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pentakillpdm123.navigation.NavRoutes


@Composable
    fun NavigationHost(navController: NavHostController){

    NavHost(navController = navController, startDestination = NavRoutes.home.route){
        composable(NavRoutes.home.route){
            com.example.pentakillpdm123.Home()
        }
        composable(NavRoutes.news.route){
            com.example.pentakillpdm123.News()
        }
        composable(NavRoutes.stream.route){
            com.example.pentakillpdm123.Stream()
        }
        composable(NavRoutes.social.route){
            com.example.pentakillpdm123.Social()
        }
        composable(NavRoutes.profile.route){
            com.example.pentakillpdm123.Profile()
        }
    }
}