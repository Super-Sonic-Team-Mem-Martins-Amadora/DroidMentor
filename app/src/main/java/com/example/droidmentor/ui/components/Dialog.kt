package com.example.droidmentor.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Dialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    onConfirmation: (@Composable ()-> Unit)? = null,
    title: String? = null,
    content: (@Composable ()-> Unit)? = null
){
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        confirmButton = {
            onConfirmation?.invoke()
        },
        text = {
            Column(
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    if (title != null){
                        Text(
                            text = title,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimary,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
                content?.invoke()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DialogPreview(){
    PreviewBox(padding = 20.dp) {
        var openAlertDialog by remember { mutableStateOf(false) }
        DroidButton(
            label = "Click Here",
            onClick = {
                openAlertDialog = true
            }
        )
        if (openAlertDialog){
            Dialog(
                onDismissRequest = {
                    openAlertDialog = false
                },
                onConfirmation = {},
                title = "Theme"
            )
        }
    }
}