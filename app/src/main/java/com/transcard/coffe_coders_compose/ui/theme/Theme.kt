package com.transcard.coffe_coders_compose.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PlatziBlue,
    primaryVariant = PlatziBlue,
    secondary = PlatziGreen
)

private val LightColorPalette = lightColors(
    primary = PlatziBlue,
    primaryVariant = PlatziBlue,
    secondary = PlatziGreen

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Coffee_coders_composeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    val type = if(darkTheme) {
        TypographyDark
    } else {
        Typography
    }

    MaterialTheme(
        colors = colors,
        typography = type,
        shapes = Shapes,
        content = content
    )
}