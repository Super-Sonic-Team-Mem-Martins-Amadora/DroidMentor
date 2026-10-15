package com.example.droidmentor.ui.screens

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.domain.Msg
import com.example.droidmentor.ui.components.ChatList
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

    val lazyListState = rememberLazyListState()

    // firstVisibleItemIndex -> first visible item
    // firstVisibleItemScrollOffset -> pixels quantity that past the first item
    // derivedStateOf -> only recomposes when the calculate state changes the state
    val expanded by remember {
        derivedStateOf {
            lazyListState.firstVisibleItemIndex == 0 &&
                    lazyListState.firstVisibleItemScrollOffset == 0

        }
    }

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

    Scaffold(
        topBar = header,
        floatingActionButton = {
            /*
            ExtendedFloatingActionButton because has the expanded property that allows
            to shrink to just an icon naturally
            */
            ExtendedFloatingActionButton(
                onClick = {},
                expanded = expanded,
                icon = {
                    DroidIcon(
                        iconFile = R.drawable.add,
                        iconDesc = "New Chat",
                        iconSize = 24.dp)
                },
                text = {
                    Text("New Chat")
                },
                contentColor = MaterialTheme.colorScheme.onPrimary,
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.border(
                    width = 2.dp,
                    MaterialTheme.colorScheme.outlineVariant,
                    RoundedCornerShape(12.dp)
                )

            )
        },
        floatingActionButtonPosition = FabPosition.End,
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
            SearchInput(
                onHandler = { input ->
                    Log.d("teste", input)
                },
                modifier = Modifier.fillMaxWidth()
            )
            ChatList(
                chatList = chatList,
                lazyListState = lazyListState,
                modifier = Modifier.fillMaxWidth(),
                withTimestamp = true,
                topFade = true
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