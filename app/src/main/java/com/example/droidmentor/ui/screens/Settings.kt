package com.example.droidmentor.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.components.Dialog
import com.example.droidmentor.ui.components.DroidButton
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox
import com.example.droidmentor.ui.components.headerSize
import com.example.droidmentor.ui.components.spacing

data class SettingButton(
    val label : String,
    val action : () -> Unit,
    val content: @Composable ()-> Unit,
)

@Composable
fun Settings(
    onBack: () -> Unit = {},
    onEasterEgg: () -> Unit = {},
    onOpenAbout: () -> Unit = {}
){

    var openAlertDialog by remember { mutableStateOf(false) }
    var currentLabel by remember { mutableStateOf("") }

    val settingsOptions = arrayOf(
        SettingButton(
            label = "Theme",
            action = {
                currentLabel = "Theme"
                openAlertDialog = true
            },
            content = {

                DroidButton(
                    label = "Light",
                    onClick = {},
                    alignLeft = true,
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.chat_bubble,
                            iconSize = 24.dp,
                            iconDesc = "Chat Bubble"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                DroidButton(
                    label = "Dark",
                    alignLeft = true,
                    onClick = {},
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.chat_bubble,
                            iconSize = 24.dp,
                            iconDesc = "Chat Bubble"
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        ),
        SettingButton(
            label = "Chat Settings",
            action = {},
            content = {}
        ),
        SettingButton(
            label = "Permissions",
            action = {},
            content = {}
        ),
        SettingButton(
            label = "API KEYS",
            action = {},
            content = {}
        ),
        SettingButton(
            label = "About",
            action = onOpenAbout,
            content = {}
        ),
    )

    Scaffold(
        topBar = {
            Column {
                Header(
                    title = "Settings",
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
                            iconFile = R.drawable.settings,
                            iconDesc = "Settings",
                            iconSize = headerSize
                        )
                    },
                    modifier = Modifier.padding(20.dp)
                )
            }

        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null, // no ripple, so it stays invisible
                        onClick = onEasterEgg //Easter egg
                    )
            )
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
                settingsOptions.forEach { option ->
                    DroidButton(
                        label = option.label,
                        onClick = option.action,
                        alignLeft = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if(openAlertDialog && option.label == currentLabel) {
                        Dialog(
                            onDismissRequest = {
                                openAlertDialog = false
                            },
                            onConfirmation = {},
                            title = option.label,
                            content = option.content
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview(){
    PreviewBox(padding = 20.dp, dark = true) {
        Settings()
    }
}