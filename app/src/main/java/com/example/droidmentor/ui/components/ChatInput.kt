package com.example.droidmentor.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatInput(


) {
    Surface(
        shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp),
        border = BorderStroke(3.dp, MaterialTheme.colorScheme.primary),
        modifier = Modifier.fillMaxWidth().height(90.dp)
    ) {
        //TextField()
        Box(
            modifier = Modifier.padding(14.dp)
        ) {

        }
    }
}


@Preview
@Composable
fun ChatInputPreview() {
    PreviewBox() {
        ChatInput()
    }
}