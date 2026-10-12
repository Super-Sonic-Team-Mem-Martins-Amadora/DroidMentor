package com.example.droidmentor.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp

@Composable
fun DroidIcon(
    iconFile: Int,
    iconSize: Dp,
    tint: Color? = null,
    iconDesc: String? = null,
    modifier: Modifier = Modifier
){
    Icon(
        painter = painterResource(id = iconFile),
        contentDescription = iconDesc,
        tint = tint ?: MaterialTheme.colorScheme.onPrimary,
        modifier = modifier.size(iconSize)
    )
}