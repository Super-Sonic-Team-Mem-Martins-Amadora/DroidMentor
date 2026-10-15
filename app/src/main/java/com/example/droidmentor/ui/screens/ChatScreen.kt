package com.example.droidmentor.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.core.domain.Account
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.domain.Msg
import com.example.droidmentor.ui.components.ChatInput
import com.example.droidmentor.ui.components.Conversation
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.PreviewBox
import com.example.droidmentor.ui.theme.DroidMentorTheme
import java.time.LocalDateTime

@Composable
fun ChatScreen(
    conversation: Chat,
){
    val newChat = conversation.messages.isEmpty()

    val logo = @Composable {
        DroidIcon(
            iconFile = R.drawable.logo,
            iconSize = 50.dp,
            iconDesc = "DroidMentor",
            tint = Color.Unspecified
        )
    }

    val header = @Composable {
        Header(
            button = {
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.burger,
                            iconSize = 50.dp,
                            iconDesc = "Sidebar"
                        )
                    },
                    onClick = {

                    }
                )
            },
            icon = if (!newChat) logo else null,
            modifier = Modifier.padding(5.dp)
        )
    }

    Scaffold(
        topBar = header,
        //containerColor = Color.Black,
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Conversation(
                conversation,
                bottom = {
                    Spacer(modifier = Modifier.height(120.dp))
                },
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            ChatInput(
                modifier = Modifier
                    .padding(15.dp)
                    .height(90.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview
@Composable
fun ChatScreenPreview() {

    val ai = Account(
        "ai",
        "AI",
        false,
    )

    val user = Account(
        "man",
        "Human Man",
        true
    )

    val messages = listOf(
        "Hello, how are you",
        "I am fine.",
        "Can you wash my dog?",
        "As an LLM I am unable to interact with your doggy, I apologise!",
        "Bro pleaseeee \uD83E\uDD7A I will do anything im soooooo lazy please chat chippidy help me",
        "I'm not ChatGPT so I'm unable to assist you but I will see what I can do, try again later.",
        "ok chat gippidy, thank you chat chippidy",
        "Its not a problem! If you need anything else, dont hesitate to ask!"
    )

    val chat = Chat(
        title = "Chat Screen Example",
        messages = buildList {
            messages.forEachIndexed { i, msg ->
                add(Msg(msg, if (i % 2 == 0) user else ai))
            }
        } as MutableList<Msg>,
        createdDate = LocalDateTime.now(),
        lastDateModified = LocalDateTime.now()
    )
    DroidMentorTheme {
        ChatScreen(
            chat
        )
    }
}