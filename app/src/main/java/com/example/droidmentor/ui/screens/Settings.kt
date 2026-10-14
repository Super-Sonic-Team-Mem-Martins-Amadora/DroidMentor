package com.example.droidmentor.ui.screens

import android.R.attr.top
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.components.DroidButton
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox
import com.example.droidmentor.ui.theme.AppTheme

data class SettingButton(
    val label : String,
    val action : () -> Unit
)

val settingsOptions = arrayOf(
    SettingButton(
        label = "Theme",
        action = {}
    ),
    SettingButton(
        label = "Chat Settings",
        action = {}
    ),
    SettingButton(
        label = "Permissions",
        action = {}
    ),
    SettingButton(
        label = "API KEYS",
        action = {}
    ),
)

@Composable
fun Settings(){
    Scaffold(
        containerColor = AppTheme.colors.background,
        contentColor = AppTheme.colors.primaryText,
        topBar = {
            Header(
                title = "Settings",
                button = {
                    IconButton(
                        icon = {
                            DroidIcon(
                                iconFile = R.drawable.back,
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
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null, // no ripple, so it stays invisible
                        onClick = {} //easter egg
                    )
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
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
                        onClick = option.action
                    )
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