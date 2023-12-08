package com.example.pentakillpdm123.home.views

import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pentakillpdm123.BottomNavBar
import com.google.accompanist.web.WebView
import com.google.accompanist.web.rememberWebViewState

@Composable
fun AboutScreen(navController: NavController) {
    var selectedProfileUrl by remember { mutableStateOf<String?>(null) }

    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("PENTAKILL.gg", fontSize = 24.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(16.dp))
            Text("¡Forja tu leyenda, conquista el campo de batalla y eleva tu espíritu de invocador en League of Legends, donde cada partida es una oportunidad para brillar!", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Materia: Programación de dispositivos móviles II", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Equipo:", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(20.dp))
            MemberInfo("Sergio Morales", "https://github.com/Serch32") {
                selectedProfileUrl = it
            }
            Spacer(modifier = Modifier.height(10.dp))

            MemberInfo("Andres Legarreta", "https://github.com/AndresLegarreta") {
                selectedProfileUrl = it
            }

            Spacer(modifier = Modifier.height(20.dp))

            selectedProfileUrl?.let { url ->
                val webViewState = rememberWebViewState(url)
                WebView(
                    state = webViewState,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    onCreated = { webView ->
                        webView.webViewClient = WebViewClient()
                    }
                )
            }
        }
    }
}

@Composable
fun MemberInfo(name: String, githubUrl: String, onProfileSelected: (String) -> Unit) {
    val context = LocalContext.current
    val annotatedString = buildAnnotatedString {
        append(name)
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append(" (Github)")
        }
    }
    ClickableText(
        text = annotatedString,
        onClick = {
            onProfileSelected(githubUrl)
        }
    )

}