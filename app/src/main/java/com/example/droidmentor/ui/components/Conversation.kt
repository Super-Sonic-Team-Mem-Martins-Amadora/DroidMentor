package com.example.droidmentor.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

data class Chat(val isUser: Boolean, val author: String, val content: String)

@Composable
fun Conversation(
    chats: List<Chat>
) {
    val scrollState = rememberScrollState()
    LazyColumn {
        items(chats) { chat ->
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                ChatBubble(
                    chat.content,
                    chat.isUser,
                    author = chat.author,
                    modifier = Modifier.align(if (chat.isUser) Alignment.CenterEnd else Alignment.CenterStart)
                )
            }
        }

    }
}

@Preview
@Composable
fun ConversationPreview() {
    val chats = listOf(
        Chat(true, "Man", "Hello, how are you"),
        Chat(false, "AI", "I am fine!"),
        Chat(true, "Man", "Can you wash my dog"),
        Chat(false, "AI", "As an LLM I am unable to interact with your pet, I apologise!"),
        Chat(true, "Man", "Hello, how are you"),
        Chat(false, "AI", "I am fine!"),
        Chat(true, "Man", "Can you wash my dog"),
        Chat(false, "AI", "As an LLM I am unable to interact with your pet, I apologise!"),
        Chat(true, "Man", "Hello, how are you"),
        Chat(false, "AI", "I am fine!"),
        Chat(true, "Man", "Can you wash my dog"),
        Chat(false, "AI", "As an LLM I am unable to interact with your pet, I apologise!"),
        Chat(true, "Man", "Hello, how are you"),
        Chat(false, "AI", "I am fine!"),
        Chat(true, "Man", "Can you wash my dog"),
        Chat(false, "AI", "As an LLM I am unable to interact with your pet, I apologise!"),
        Chat(true, "Man", "Hello, how are you"),
        Chat(false, "AI", "I am fine!"),
        Chat(true, "Man", "Can you wash my dog"),
        Chat(false, "AI", "As an LLM I am unable to interact with your pet, I apologise!"),
    )

    PreviewBox {
        Conversation(
            chats
        )
    }
}