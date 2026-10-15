package com.example.droidmentor.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

import androidx.compose.ui.graphics.Color

data class AppColors(
    val primaryText : Color,
    val subtitleText : Color,
    val aiText : Color,
    val userText : Color,
    val buttonContainer : Color,
    val buttonContainerBorder : Color,
    val userTextContainer : Color,
    val userTextContainerBorder :Color,
    val aiTextContainer :Color,
    val aiTextContainerBorder : Color,
    val background : Color,
    val loadingMessage : Color,
    val authorText : Color
)

private val DarkColorScheme1 = AppColors(
    primaryText = White,
    subtitleText = Gray,
    aiText = White,
    userText = White,
    authorText = LightGray,
    buttonContainer = DarkishGray,
    buttonContainerBorder = LightGray,
    userTextContainer = Blue,
    userTextContainerBorder = LightGray,
    aiTextContainer = Black,
    aiTextContainerBorder = DarkRed,
    loadingMessage = Gold,
    background = DarkGray,
)

/*
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
        tertiaryContainer = DarkishGray
    )
*/

private val LightColorScheme1 = AppColors(
    primaryText = Black,
    subtitleText = Blue,
    aiText = White,
    userText = Black,
    authorText = DarkGray,
    buttonContainer = Blue,
    buttonContainerBorder = Black,
    userTextContainer = White,
    userTextContainerBorder = Blue,
    aiTextContainer = Black,
    aiTextContainerBorder = DarkRed,
    background = LightGray,
    loadingMessage = MetalGold,
)

/*
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
        tertiaryContainer = Blue
    )
*/

//value that any composable at a certain point of the tree can read, like Context
private val LocalAppColors = staticCompositionLocalOf { LightColorScheme1 }

object AppTheme {
    val colors: AppColors
        @Composable get() = LocalAppColors.current
}

@Composable
fun DroidMentorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalAppColors provides if (darkTheme) DarkColorScheme1 else LightColorScheme1
    ) {
        MaterialTheme(typography = Typography, content = content)
    }
}