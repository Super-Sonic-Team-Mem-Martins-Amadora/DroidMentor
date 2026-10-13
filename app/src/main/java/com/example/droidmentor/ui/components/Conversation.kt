package com.example.droidmentor.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

data class Chat(val isUser: Boolean, val author: String, val content: String)

@Composable
fun Conversation(
    chats: List<Chat>
) {
    Column() {
        chats.forEach{ chat ->
            ChatBubble(
                chat.content,
                chat.isUser,
                author = chat.author,
                modifier = Modifier.align(if (chat.isUser) Alignment.End else Alignment.Start)
            )
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
    )

    PreviewBox {
        Conversation(
            chats
        )
    }
}