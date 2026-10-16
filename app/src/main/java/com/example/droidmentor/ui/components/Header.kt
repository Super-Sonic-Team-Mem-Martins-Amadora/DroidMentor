package com.example.droidmentor.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R

@Composable
fun Header(
    button: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    title: String? = null,
    icon: @Composable (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.width(48.dp).fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            button()
        }
        if (title != null) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
        Box(
            modifier = Modifier.width(48.dp).fillMaxHeight(),
            contentAlignment = Alignment.Center
        ) {
            icon?.invoke()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview(){
    PreviewBox(padding = 20.dp) {
        Header(
            title = "Settings",
            button = {
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.back,
                            iconDesc = "Back",
                            iconSize = 24.dp
                        )
                    },
                    onClick = {},
                    modifier = Modifier.size(48.dp)
                )
            },
            icon = {
                DroidIcon(
                    iconFile = R.drawable.settings,
                    iconDesc = "Settings",
                    iconSize = 24.dp
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreviewWithIcon(){
    PreviewBox(padding = 20.dp) {
        Header(
            button = {
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.back,
                            iconDesc = "Back",
                            iconSize = 24.dp
                        )
                    },
                    onClick = {},
                    modifier = Modifier.size(48.dp)
                )
            },
            icon = {
                DroidIcon(
                    iconFile = R.drawable.settings,
                    iconDesc = "Settings",
                    iconSize = 24.dp
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreviewNull(){
    PreviewBox(padding = 20.dp) {
        Header(
            button = {
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.back,
                            iconDesc = "Back",
                            iconSize = 24.dp
                        )
                    },
                    onClick = {},
                    modifier = Modifier.size(48.dp)
                )
            },
        )
    }
}
