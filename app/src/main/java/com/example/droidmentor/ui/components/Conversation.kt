package com.example.droidmentor.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.core.domain.Account
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.domain.Msg
import java.time.LocalDateTime

@Composable
fun Conversation(
    chat: Chat,
    modifier: Modifier = Modifier
) {
    val lazylistState = rememberLazyListState()

    val topAlpha by animateFloatAsState(if (lazylistState.canScrollForward) 1f else 0f, label = "topFade")
    val bottomAlpha by animateFloatAsState(if (lazylistState.canScrollBackward) 1f else 0f, label = "bottomFade")
    Box(
        modifier = modifier
    ) {
        LazyColumn(
            reverseLayout = true,
            state = lazylistState
        ) {
            items(chat.messages.reversed()) { msg ->
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    val acc = msg.account
                    ChatBubble(
                        msg.content,
                        acc.isUser,
                        author = acc.displayName,
                        modifier = Modifier.align(if (acc.isUser) Alignment.CenterEnd else Alignment.CenterStart)
                    )
                }
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .height(50.dp)
                .graphicsLayer { alpha = topAlpha }
                .background(
                    Brush.verticalGradient(
                        listOf(MaterialTheme.colorScheme.background, Color.Transparent)
                    )
                )
        )
        Box(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(50.dp)
                .graphicsLayer { alpha = bottomAlpha }
                .background(
                    Brush.verticalGradient(
                        colors = listOf(MaterialTheme.colorScheme.background, Color.Transparent),
                        startY = Float.POSITIVE_INFINITY,
                        endY = 0.0f,
                    )
                )
        )
    }
}

@Preview
@Composable
fun ConversationPreview() {

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
        "I'm not ChatGPT so I'm unable to assist you but I will see what I can do, try again later."
    )

    val chats = Chat(
        title = "Example",
        messages = buildList {
            messages.forEachIndexed { i, msg ->
                add(Msg(msg, if (i % 2 == 0) user else ai))
            }
        } as MutableList<Msg>,
        createdDate = LocalDateTime.now(),
        lastDateModified = LocalDateTime.now()
    )

    PreviewBox {
        Conversation(
            chats
        )
    }
}

@Preview
@Composable
fun LongConversationPreview() {

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
        "I'm not ChatGPT so I'm unable to assist you but I will see what I can do, try again later."
    )

    val chats = Chat(
        title = "Example",
        messages = buildList {
            var i = 0
            while (i < 5) {
                messages.forEachIndexed { i, msg ->
                    add(Msg(msg, if (i % 2 == 0) user else ai))
                }
                i++
            }
        } as MutableList<Msg>,
        createdDate = LocalDateTime.now(),
        lastDateModified = LocalDateTime.now()
    )

    PreviewBox {
        Conversation(
            chats
        )
    }
}