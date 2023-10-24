package com.example.pentakillpdm123.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val MyGray = Color(0xFFE0E0E0)
val BlackColor = Color(0xFF000000)



private val DarkColorPalette = darkColors(
    primary = MyGray,
    primaryVariant = MyGray,
    secondary = MyGray
)

private val LightColorPalette = lightColors(
    primary = MyGray,
    primaryVariant = MyGray,
    secondary = MyGray,
    background = MyGray,
    surface = MyGray
)


@Composable
fun Pentakillpdm123Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}