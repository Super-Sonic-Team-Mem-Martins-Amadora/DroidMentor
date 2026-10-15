package com.example.droidmentor.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Composable
fun DroidButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    alignLeft : Boolean = false,
    border : BorderStroke? = null,
    icon: @Composable (() -> Unit)? = null,
){
    Surface(
        onClick = onClick,
        modifier = modifier,
        shape = ButtonDefaults.shape,
        color = MaterialTheme.colorScheme.tertiaryContainer,
        border = border ?: BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize(
                    minWidth = ButtonDefaults.MinWidth,
                    minHeight = ButtonDefaults.MinHeight,
                )
                .padding(ButtonDefaults.ContentPadding),
            horizontalArrangement = if (alignLeft) Arrangement.Start else Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (icon != null) {
                icon()
                //spacing between icon ant text
                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
            }
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DroidButtonPreviewIcons() {
    PreviewBox(dark = true) {
        Column(
            modifier = Modifier.padding(10.dp, 0.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            // Without icon
            DroidButton(
                label = "No icon",
                onClick = {},
                alignLeft = false,
                modifier = Modifier.fillMaxWidth()
            )

            // With icon
            DroidButton(
                label = "Icon",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                icon = {
                    Box(
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                            .background(Color.Magenta)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DroidButtonPreviewfuns() {
    var count by remember { mutableIntStateOf(0) }
    PreviewBox(dark = true){
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Counter: $count",
                color = MaterialTheme.colorScheme.onPrimary
            )
            // counter
            Row (
                modifier = Modifier.padding(10.dp, 0.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                DroidButton(
                    label = "Counter up",
                    onClick = { count++ },
                    alignLeft = false,
                    icon = {
                        Box(
                            modifier = Modifier
                                .size(ButtonDefaults.IconSize)
                                .background(Color.Green)
                        )
                    }
                )

                DroidButton(
                    label = "Counter down",
                    onClick = { if (count > 0) count-- },
                    alignLeft = false,
                    icon = {
                        Box(
                            modifier = Modifier
                                .size(ButtonDefaults.IconSize)
                                .background(Color.Red)
                        )
                    }
                )
            }
        }
    }
}