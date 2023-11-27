package com.example.pentakillpdm123


import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.BottomNavigation
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pentakillpdm123.navigation.NavBarItems

@Composable
fun BottomNavBar(navController: NavController) {
    BottomNavigation {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route

        NavBarItems.forEach { navItem ->

            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = navItem.image,
                        contentDescription = navItem.title.toString(),
                        tint = if (currentRoute == navItem.route) Color.Black else Color.Black // Cambiar el color del icono
                    )
                },
                label = {
                    Text(
                        text = navItem.title,
                        color = if (currentRoute == navItem.route) Color.Black else Color.Black // Cambiar el color del texto
                    )
                },
                selectedContentColor = Color.Black, // Cambiar el color del contenido seleccionado
                unselectedContentColor = Color.Black // Cambiar el color del contenido no seleccionado
            )

        }
    }
}




@Composable
private fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route

}