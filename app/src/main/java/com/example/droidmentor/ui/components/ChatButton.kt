package com.example.droidmentor.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import java.time.Instant

@Composable
fun ChatButton(
    chatTitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
){
    val instant = Instant.now()
}