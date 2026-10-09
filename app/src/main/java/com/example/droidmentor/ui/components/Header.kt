package com.example.droidmentor.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Header(
    title: String,
    button: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        button()
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )
        icon()
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview(){
    Header(
        "Settings",
        {
            Box(
                modifier = Modifier
                    .size(ButtonDefaults.IconSize)
                    .background(Color.Red)
            ) {
                Text("B")
            }
        },
        {
            Box(
                modifier = Modifier
                    .size(ButtonDefaults.IconSize)
                    .background(Color.Red)
            ) {
                Text("I")
            }
        }
    )
}