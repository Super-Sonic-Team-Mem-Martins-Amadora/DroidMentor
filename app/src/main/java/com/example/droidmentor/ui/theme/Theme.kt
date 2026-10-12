package com.example.droidmentor.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Gray,
    onPrimary = White,
    primaryContainer = Blue,
    secondary = DarkRed,
    secondaryContainer = Black,
    background = DarkGray,
    tertiary = Gold,
    surfaceDim = Gray
)

private val LightColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = Black,
    primaryContainer = White,
    secondary = DarkRed,
    secondaryContainer = Black,
    background = LightGray,
    tertiary = MetalGold,
    surfaceDim = Gray
)

@Composable
fun DroidMentorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    // dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        /*dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}