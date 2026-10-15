package com.example.droidmentor.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox
import com.example.droidmentor.ui.theme.AppTheme

const val version = "1.0.0"

@Composable
fun About(){
    Scaffold(
        containerColor = AppTheme.colors.background,
        contentColor = AppTheme.colors.primaryText,
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
        },
        //bottomBar = sonic picture
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "Version $version",
                color = AppTheme.colors.primaryText,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier,
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = buildAnnotatedString {
                    append("Proudly Built by:")
                    withBulletList {
                        withBulletListItem { append("Ricardo Martins") }
                        withBulletListItem { append("Manuel Abreu") }
                        withBulletListItem { append("Maximus Delorey") }
                    }
                },
                color = AppTheme.colors.primaryText,
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