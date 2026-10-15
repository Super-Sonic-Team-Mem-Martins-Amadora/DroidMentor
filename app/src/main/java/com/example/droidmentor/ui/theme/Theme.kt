package com.example.droidmentor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = Black,
    onSecondary = White,
    primaryContainer = White,
    secondary = DarkRed,
    secondaryContainer = Black,
    background = LightGray,
    tertiary = MetalGold,
    surfaceDim = Gray,
    outline = Blue,
    outlineVariant = Black,
    tertiaryContainer = Blue
)

private val DarkColorScheme = darkColorScheme(
    primary = LightGray,
    onPrimary = White,
    onSecondary = Black,
    primaryContainer = Blue,
    secondary = DarkRed,
    secondaryContainer = Black,
    background = DarkGray,
    tertiary = Gold,
    surfaceDim = LightGray,
    outline = LightGray,
    outlineVariant = LightGray,
    tertiaryContainer = DarkishGray
)

@Composable
fun DroidMentorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}