package com.example.droidmentor.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.toClipEntry
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat.getSystemService
import com.example.droidmentor.R
import com.example.droidmentor.ui.components.DroidButton
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox
import com.example.droidmentor.ui.components.headerSize

const val version = "1.0"

@Composable
fun About(
    onBack: () -> Unit = {}
){
    data class AboutButton(
        val label : String,
        val action : () -> Unit,
        val icon : Unit? = null,
    )

    val aboutOptions = arrayOf(
        AboutButton(
            label = "Version $version",
            //icon = DroidIcon(),
            action = {
               //copy to clipboard here
            }
        ),
        AboutButton(
            label = "Chat Settings",
            //icon = DroidIcon(),
            action = {}
        ),
        AboutButton(
            label = "Permissions",
            //icon = DroidIcon(),
            action = {}
        ),
        AboutButton(
            label = "API KEYS",
            //icon = DroidIcon(),
            action = {}
        ),
        AboutButton(
            label = "About",
            //icon = DroidIcon(),
            action = {}
        ),
    )

    Scaffold(
        topBar = {
            Column{
                Header(
                    title = "About",
                    button = {
                        IconButton(
                            icon = {
                                DroidIcon(
                                    iconFile = R.drawable.back,
                                    iconDesc = "Back",
                                    iconSize = headerSize,
                                )
                            },
                            onClick = onBack,
                            modifier = Modifier.size(headerSize)
                        )
                    },
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.info,
                            iconDesc = "Settings",
                            iconSize = headerSize
                        )
                    },
                    modifier = Modifier.padding(20.dp)
                )
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                aboutOptions.forEach { option ->
                    DroidButton(
                        label = option.label,
                        onClick = option.action,
                        alignLeft = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
/*
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
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
*/

@Preview(showBackground = true)
@Composable
fun AboutPreview(){
    PreviewBox(padding = 0.dp, dark = true) {
        About()
    }
}