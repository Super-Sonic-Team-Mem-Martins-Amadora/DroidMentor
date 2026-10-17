package com.example.droidmentor.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox
import com.example.droidmentor.ui.components.spacing

const val version = "1.0"

@Composable
fun About(
    onBack: () -> Unit = {}
){
    Scaffold(
        topBar = {
            Column{
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
                            onClick = onBack,
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
                Spacer(Modifier.height(spacing))
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val baseSize = 300.dp

                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds, // stretch instead of keeping aspect ratio
                    modifier = Modifier.size(
                        width = baseSize * 2f,
                        height = baseSize * 0.5f,
                    ),
                )

            }

        }
    ) { innerPadding ->
        Column(
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