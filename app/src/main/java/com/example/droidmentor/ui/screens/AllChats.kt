package com.example.droidmentor.ui.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.domain.Msg
import com.example.droidmentor.ui.components.ChatList
import com.example.droidmentor.ui.components.DroidButton
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.SearchInput
import com.example.droidmentor.ui.theme.DroidMentorTheme
import java.time.LocalDateTime

@Composable
fun AllChats(
    chatList: List<Chat>
){

    val header = @Composable {
        Header(
            title = "AllChats",
            button = {
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.menu_square,
                            iconDesc = "Sidebar",
                            iconSize = 24.dp
                        )
                    },
                    onClick = {},
                    modifier = Modifier.size(48.dp)
                )
            },
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat_bubble,
                    iconDesc = "Chat Bubble",
                    iconSize = 24.dp
                )
            },
            modifier = Modifier.padding(20.dp)
        )
    }

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
                modifier = Modifier.weight(1f)
            )
        }
    }

    Scaffold(
        topBar = header,
        bottomBar = bottom,
        modifier = Modifier.fillMaxSize().imePadding()
    ) { innerPadding ->
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 10.dp)
        ) {
            SearchInput(
                onHandler = { input ->
                    Log.d("teste", input)
                },
                modifier = Modifier.fillMaxWidth()

            )
            ChatList(
                chatList = chatList,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AllChatsPreview(){

    val chats = buildList {
        var i = 0
        while (i < 15) {
            add(Chat(
                messages = mutableListOf<Msg>(),
                title = "Chat $i",
                lastDateModified = LocalDateTime.now()
            ))
            i++
        }
    }
    DroidMentorTheme(darkTheme = true) {
        AllChats(chats)
    }


}