package com.tuempresa.vetturnos.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color.White,
    background = Color(0xFFF1F8E9),
    onBackground = Color.Black
)

@Composable
fun VetturnosTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}
