package com.example.droidmentor.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.ui.components.DroidButton
import com.example.droidmentor.ui.components.DroidIcon

@Composable
fun Sidebar(
    chatList: List<Chat>
){

    val bottom = @Composable {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(70.dp)
        ) {
            DroidButton(
                onClick = {},
                label = "About",
                icon = {
                    DroidIcon(
                        iconFile = R.drawable.info,
                        iconDesc = "Info",
                        iconSize = 24.dp
                    )
                },
                border = BorderStroke(
                    2.dp,
                    MaterialTheme.colorScheme.outlineVariant
                ),
                modifier = Modifier
                    .weight(1f)

            )
            DroidButton(
                onClick = {},
                label = "Settings",
                icon = {
                    DroidIcon(
                        iconFile = R.drawable.settings,
                        iconDesc = "Settings",
                        iconSize = 24.dp
                    )
                },
                border = BorderStroke(
                    2.dp,
                    MaterialTheme.colorScheme.outlineVariant
                ),
                modifier = Modifier.weight(1f)
            )
        }
    }

}