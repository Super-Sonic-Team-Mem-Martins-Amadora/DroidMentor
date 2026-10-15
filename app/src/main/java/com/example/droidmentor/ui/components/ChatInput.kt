package com.example.droidmentor.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R

@Composable
fun ChatInput(


) {
    var chatInput by remember { mutableStateOf("") }

    Surface(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(3.dp, color = MaterialTheme.colorScheme.primary),
        modifier = Modifier.fillMaxWidth().height(90.dp)
    ) {
        Row {
            TextField(
                value = chatInput,
                onValueChange = {},
                modifier = Modifier.padding(14.dp)
            )
            Button(
                shape = RoundedCornerShape(20.dp),
                onClick = {}
            ) {
                DroidIcon(
                    iconFile = R.drawable.send,
                    iconSize = 40.dp
                )
            }
        }
    }
}


@Preview
@Composable
fun ChatInputPreview() {
    PreviewBox {
        ChatInput()
    }
}