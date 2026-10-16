package com.example.droidmentor.ui.components

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.example.droidmentor.R
import com.example.droidmentor.core.domain.Chat
import java.time.LocalDateTime

@Composable
fun ChatList(
    chatList: List<Chat>,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState(),
    withTimestamp: Boolean = false,
    topFade: Boolean = false,
    bottomFade: Boolean = false,
    bottom: (@Composable ()-> Unit)? = null
){

    // Backwards -> Top
    // Forwards -> Bottom
    val topAlpha by animateFloatAsState(if (lazyListState.canScrollBackward) 1f else 0f, label = "topFade")
    val bottomAlpha by animateFloatAsState(if (lazyListState.canScrollForward) 1f else 0f, label = "bottomFade")

    Box(
        modifier = modifier
    ) {
        LazyColumn(
            state = lazyListState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
        ) {
            items(chatList) { chat ->
                ChatButton(
                    chatTitle = chat.title,
                    onClick = {},
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.chat,
                            iconSize = 32.dp
                        )
                    },
                    lastDateModified = if (withTimestamp) chat.lastDateModified else null,
                )
            }
            if (bottom != null) {
                item {
                    bottom()
                }
            }
        }
        if (topFade) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .height(50.dp)
                    .graphicsLayer {
                        Log.d("topAlpha","$topAlpha")
                        alpha = topAlpha }
                    .background(
                        Brush.verticalGradient(
                            listOf(MaterialTheme.colorScheme.background, Color.Transparent)
                        )
                    )
            )
        }
        if (bottomFade) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .height(50.dp)
                    .graphicsLayer {
                        Log.d("bottomAlpha","$bottomAlpha")
                        alpha = bottomAlpha }
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


}

@Preview(showBackground = true)
@Composable
fun ChatListPreviewWithoutTimeStamp(){

    val chats = buildList {
        var i = 0
        while (i < 15) {
            add(Chat(
                messages = mutableListOf(),
                title = "Chat $i",
                lastDateModified = LocalDateTime.now()
            ))
            i++
        }
    }
    PreviewBox {
        ChatList(
            chatList = chats,
            withTimestamp = true,
            topFade = true,
            bottomFade = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatListPreviewWithTimeStamp(){

    val chats = buildList {
            var i = 0
            while (i < 15) {
                    add(Chat(
                        messages = mutableListOf(),
                        title = "Chat $i",
                        lastDateModified = LocalDateTime.now()
                    ))
                i++
            }
        }

    PreviewBox {
        ChatList(
            chatList = chats,
            withTimestamp = false,
            topFade = true,
            bottomFade = true
        )
    }
}