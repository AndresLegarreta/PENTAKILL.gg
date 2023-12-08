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
        title = "News",
        image = Icons.Filled.Email,
        route = "newsroute"
    ),
    BarItem(
        title = "Streams",
        image = Icons.Filled.CellWifi,
        route = "notificationsroute"
    ),
    BarItem(
        title = "Profile",
        image = Icons.Filled.Person,
        route = "profileroute"
    )
)