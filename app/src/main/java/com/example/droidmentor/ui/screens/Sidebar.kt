package com.example.droidmentor.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.ui.components.ChatList
import com.example.droidmentor.ui.components.DroidButton
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.headerSize
import com.example.droidmentor.ui.theme.DroidMentorTheme
import java.time.LocalDateTime

@Composable
fun Sidebar(
    chatList: List<Chat>,
    onCloseSidebar: () -> Unit = {},
    onOpenNewChat: () -> Unit = {},
    onOpenSettings: () -> Unit = {},
    onOpenAllChats: () -> Unit = {},
    onOpenChat: (Int) -> Unit = {},
){

    val lazyListState = rememberLazyListState()

    val header = @Composable {
        Header(
            title = "Sidebar",
            button = {
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.burger,
                            iconDesc = "Sidebar",
                            iconSize = headerSize
                        )
                    },
                    onClick = onCloseSidebar,
                    modifier = Modifier.size(headerSize)
                )
            },
            icon = {
                DroidIcon(
                    iconFile = R.drawable.logo,
                    iconDesc = "Chat Bubble",
                    iconSize = headerSize,
                    tint = Color.Unspecified
                )
            },
            modifier = Modifier.padding(20.dp)
        )
    }

    Scaffold(
        topBar = header,
        modifier = Modifier.fillMaxSize().imePadding()
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
            DroidButton(
                label = "All Chats",
                onClick = onOpenAllChats,
                modifier = Modifier.fillMaxWidth(),
                alignLeft = true,
                border = BorderStroke(
                    2.dp,
                    MaterialTheme.colorScheme.outlineVariant,
                ),
                icon = {
                    DroidIcon(
                        iconFile = R.drawable.chat_bubble,
                        iconSize = 24.dp,
                        iconDesc = "Chat Bubble"
                    )
                }
            )
            Text(
                "Recent Chats",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth()
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                ChatList(
                    chatList = chatList,
                    lazyListState = lazyListState,
                    modifier = Modifier.fillMaxSize(),
                    topFade = true,
                    bottom = {
                        Spacer(modifier = Modifier.size(80.dp)
                        )
                    },
                    onOpenChat = onOpenChat
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(96.dp)
                        .background(
                            Brush.verticalGradient(
                                listOf(
                                    Color.Transparent,
                                    MaterialTheme.colorScheme.background
                                )
                            )
                        )
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .padding(bottom = 17.dp)
                ) {
                    ExtendedFloatingActionButton(
                        onClick = onOpenSettings,
                        icon = {
                            DroidIcon(
                                iconFile = R.drawable.settings,
                                iconDesc = "Settings",
                                iconSize = 24.dp
                            )
                        },
                        text = {
                            Text("Settings")
                        },
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.border(
                            width = 2.dp,
                            MaterialTheme.colorScheme.outlineVariant,
                            RoundedCornerShape(12.dp)
                        )
                    )
                    ExtendedFloatingActionButton(
                        onClick = onOpenNewChat,
                        icon = {
                            DroidIcon(
                                iconFile = R.drawable.add,
                                iconDesc = "New Chat",
                                iconSize = 24.dp
                            )
                        },
                        text = {
                            Text("New Chat")
                        },
                        contentColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.border(
                            width = 2.dp,
                            MaterialTheme.colorScheme.outlineVariant,
                            RoundedCornerShape(12.dp)
                        )
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SidebarPreview(){

    val chats = buildList {
        var i = 1
        while (i < 11) {
            add(Chat(
                messages = mutableListOf(),
                title = "Chat $i Teste",
                lastDateModified = LocalDateTime.now()
            ))
            i++
        }
    }
    DroidMentorTheme(darkTheme = true) {
        Sidebar(chats)
    }
}