package com.example.pentakillpdm123.home.views

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.login.PreferencesManager

@Composable
fun ProfileView(navController: NavController, context: Context) {
    val MyGray = Color(0xFFE0E0E0)
    val preferencesManager = PreferencesManager(context)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            // Llamar a la función de cierre de sesión
            logout(navController, preferencesManager)
        },
            modifier = Modifier
                .width(100.dp)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = MyGray),
            shape = RoundedCornerShape(50),
        ) {
            Text(
                "Cerrar Sesión",
                color = Color.Black,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}

// Función para cerrar sesión
fun logout(navController: NavController, preferencesManager: PreferencesManager) {
    // Limpia los datos de sesión usando PreferencesManager
    preferencesManager.clearData()

    // Navegar de vuelta a la pantalla de inicio de sesión
    navController.navigate(NavRoutes.login.route) {
        // Limpiar el back stack para que el usuario no pueda volver a la pantalla de perfil después del logout
        popUpTo(NavRoutes.profile.route) { inclusive = true }
    }
}
