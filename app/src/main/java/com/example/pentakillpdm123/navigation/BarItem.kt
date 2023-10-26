package com.example.pentakillpdm123.navigation

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Esta es una clase de datos para los elementos del menú que aparece abajo
 */
data class BarItem(
    // Titulo de la opción
    val title: String,
    // Icono de la opción del menú
    val image: ImageVector,
    // Ruta a la cual se va a dirigir la opción
    val route: String
)
