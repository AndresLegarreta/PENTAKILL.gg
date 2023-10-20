package com.example.pentakillpdm123.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BarItems (
        val route: String,
        val title: String,
        val icon: ImageVector
    ){
    object Home: BarItems("home","home", Icons.Filled.Home)
    object News: BarItems("news","news", Icons.Filled.List)
    object Stream: BarItems("stream","stream", Icons.Filled.Share)
    object Social: BarItems("social","social", Icons.Filled.Email)
    object Profile: BarItems("profile","profile", Icons.Filled.Person)


}
