package com.example.droidmentor.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.theme.DroidMentorTheme

private val ChatBubbleShapeAI = RoundedCornerShape(0.dp, 20.dp, 20.dp, 20.dp)
private val ChatBubbleShapeMe = RoundedCornerShape(20.dp, 0.dp, 20.dp, 20.dp)


@Composable
fun Loading() {
    Row(
        modifier = Modifier.padding(top = 4.dp)
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        DroidIcon(
            iconFile = R.drawable.loading,
            iconSize = 16.dp,
            tint = MaterialTheme.colorScheme.tertiary
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = "Loading...",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun ChatBubble(
    content: String,
    isUser: Boolean,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    author: String? = null,
){
    val haptic = LocalHapticFeedback.current
    val canCopy = !isUser

    val backgroundBubbleColor = if (isUser) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.secondaryContainer
    }
    val borderBubbleColor = if (isUser) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.secondary
    }

    val textBubbleColor = if (isUser) {
        MaterialTheme.colorScheme.onPrimary
    } else {
        Color.White
    }
    val bubbleShape = if (isUser) ChatBubbleShapeMe else ChatBubbleShapeAI

    Column(
        horizontalAlignment = if (isUser) Alignment.End else Alignment.Start,
        modifier = modifier,
    ) {
        val hasText = content.isNotBlank()
        author?.let {
            Text(
                text = author,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.surfaceDim
            )
        }
        Surface(
            color = backgroundBubbleColor,
            shape = bubbleShape,
            border = BorderStroke(3.dp, borderBubbleColor),
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier.padding(14.dp)
            ) {
                if (hasText) {
                    Text(
                        text = content,
                        style = MaterialTheme.typography.bodyMedium,
                        color = textBubbleColor,
                    )
                }
            }
        }
        if (isLoading) {
            Loading()
        } else {
            if (!isUser) {

            }
        }
    }
}

@Preview
@Composable
fun UserChatBubblePreview() {
    PreviewBox {
        ChatBubble(
            author = "User",
            content = "This is a preview User chat message!",
            isUser = true,
            isLoading = false,
        )
    }
}

@Preview
@Composable
fun LoadingChatBubblePreview() {
    PreviewBox {
        ChatBubble(
            author = "Ai",
            content = "...",
            isUser = false,
            isLoading = true,
        )
    }
}

@Preview
@Composable
fun AIChatBubblePreview() {
    PreviewBox {
        ChatBubble(
            author = "Ai",
            content = "This is a preview AI chat message!",
            isUser = false,
            isLoading = false,
        )
    }
}

@Preview
@Composable
fun ChatBubbleLongPreview() {
    PreviewBox {
        ChatBubble(
            author = "Ai",
            content = "This is a long preview chat message! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque tristique nisl non dolor cursus, ac blandit sem vehicula. Praesent in orci ac eros vulputate scelerisque at vel urna. Nullam dolor arcu, tempus vel posuere sed, dictum in arcu. Aliquam in dui vehicula, tristique lorem sit amet, volutpat tortor. Etiam auctor non nunc et imperdiet. Suspendisse potenti. Etiam laoreet mi nec libero facilisis, eget rutrum nisi tincidunt. Maecenas tristique sapien vel felis porta viverra. Maecenas auctor lorem nibh, sed vestibulum orci euismod vitae. Nullam auctor dolor vitae euismod fringilla. Quisque enim odio, rutrum in mi at, sodales tristique turpis. Mauris vestibulum arcu vel velit dapibus, eu congue odio maximus. Quisque molestie venenatis euismod.",
            isUser = false,
            isLoading = false,
        )
    }
}