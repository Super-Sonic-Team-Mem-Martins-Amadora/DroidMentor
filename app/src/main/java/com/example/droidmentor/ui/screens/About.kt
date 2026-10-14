package com.example.droidmentor.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.components.DroidButton
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox

const val version = "1.0.0"

@Composable
fun About(){
    Scaffold(
        topBar = {
            Header(
                title = "About",
                button = {
                    IconButton(
                        icon = {
                            DroidIcon(
                                iconFile = R.drawable.info,
                                iconDesc = "Back",
                                iconSize = 24.dp,
                            )
                        },
                        onClick = {},
                        modifier = Modifier.size(24.dp)
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
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "Version $version",
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutPreview(){
    PreviewBox(padding = 20.dp, dark = true) {
        About()
    }
}