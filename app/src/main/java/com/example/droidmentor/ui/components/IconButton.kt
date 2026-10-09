package com.example.droidmentor.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun IconButton(
    icon: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        icon()
    }
}

@Preview(showBackground = true)
@Composable
fun IconButtonPreview(){
    IconButton(
        icon = {
            Icon(
                imageVector = Icons.AutoMirrored.Default.List,
                contentDescription = "teste")
        },
        onClick = {}
    )
}