package com.example.pentakillpdm123.navigation


sealed class NavRoutes (val route: String) {
    object home : NavRoutes("home")
    object news : NavRoutes("news")
    object stream : NavRoutes("stream")
    object social : NavRoutes("social")
    object profile : NavRoutes("profile")



}

