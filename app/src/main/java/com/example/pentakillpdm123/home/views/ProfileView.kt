package com.example.pentakillpdm123.home.views

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pentakillpdm123.navigation.NavRoutes
import com.example.pentakillpdm123.login.PreferencesManager
import android.webkit.WebViewClient
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.sp
import com.example.pentakillpdm123.BottomNavBar
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip




@Composable
fun ProfileView(navController: NavController, context: Context) {
    val MyGray = Color(0xFFE0E0E0)
    val preferencesManager = PreferencesManager(context)
    val coroutineScope = rememberCoroutineScope()

    val logoutButtonModifier = Modifier
        .size(70.dp)
        .clip(RoundedCornerShape(percent = 50))
        .background(color = MyGray)
        .padding(10.dp)

    // Modificadores para el IconButton
    val infoButtonModifier = Modifier
        .size(70.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(color = MyGray)
        .padding(16.dp)

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                // Botón para cerrar sesión (en la parte derecha)
                IconButton(
                    onClick = {
                        // Llamar a la función de cierre de sesión
                        logout(navController, preferencesManager)
                    },
                    modifier = logoutButtonModifier,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Logout,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                )

                // Botón para navegar a la pantalla AboutScreen (en el centro)
                IconButton(
                    onClick = {
                        navController.navigate(NavRoutes.aboutscreen.route)
                    },
                    modifier = infoButtonModifier,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                )
            }
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





