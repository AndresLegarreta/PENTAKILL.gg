package com.example.pentakillpdm123.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*


val  NavBarItems = listOf(
    BarItem(
        title = "Home",
        image = Icons.Filled.Home,
        route = "homemainview"
    ),
    BarItem(
        title = "Favorites",
        image = Icons.Filled.Favorite,
        route = "favoritesroute"
    ),
    BarItem(
        title = "Notifications",
        image = Icons.Filled.Notifications,
        route = "notificationsroute"
    ),
    BarItem(
        title = "Cart",
        image = Icons.Filled.ShoppingCart,
        route = "cartroute"
    )
)