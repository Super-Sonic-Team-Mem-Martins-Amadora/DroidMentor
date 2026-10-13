package com.example.droidmentor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.droidmentor.ui.theme.AppTheme
import com.example.droidmentor.ui.theme.DroidMentorTheme
import com.example.droidmentor.ui.theme.appColors

@Composable
fun PreviewBox(padding: Dp = 30.dp, dark: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    DroidMentorTheme(darkTheme = dark) {
        Box(
            modifier = Modifier
                .background(color = AppTheme.colors.background).padding(padding)
        ) {
            content()
        }
    }
}