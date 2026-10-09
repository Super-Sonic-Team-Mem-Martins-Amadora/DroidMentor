package com.example.droidmentor.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.droidmentor.ui.theme.DroidMentorTheme

private val ChatBubbleShapeAI = RoundedCornerShape(0.dp, 20.dp, 20.dp, 20.dp)
private val ChatBubbleShapeMe = RoundedCornerShape(20.dp, 0.dp, 20.dp, 20.dp)

@Composable
fun ChatBubble(
    content: String,
    isUser: Boolean,
    isLoading: Boolean,
    modifier: Modifier = Modifier
){
    val haptic = LocalHapticFeedback.current
    val canCopy = !isUser

    val backgroundBubbleColor = if (isUser) {
        MaterialTheme.colorScheme.inversePrimary
    } else {
        MaterialTheme.colorScheme.primaryContainer
    }
    val borderBubbleColor = if (isUser) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.inversePrimary
    }
    val bubbleShape = if (isUser) ChatBubbleShapeMe else ChatBubbleShapeAI

    Column(
        horizontalAlignment = if (isUser) Alignment.End else Alignment.Start,
        modifier = modifier,
    ) {
        val hasText = content.isNotBlank()

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
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        overflow = TextOverflow.Visible,
                    )
                }
            }
        }
        Loading()
    }
}

@Composable
fun PreviewBox(content: @Composable () -> Unit) {
    DroidMentorTheme(dynamicColor = false) {
        Box(
            modifier = Modifier.padding(30.dp)
        ) {
            content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserChatBubblePreview() {
    PreviewBox {
        ChatBubble(
            content = "This is a preview User chat message!",
            isUser = true,
            isLoading = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingChatBubblePreview() {
    PreviewBox {
        ChatBubble(
            content = "Loading...",
            isUser = false,
            isLoading = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AIChatBubblePreview() {
    PreviewBox {
        ChatBubble(
            content = "This is a preview AI chat message!",
            isUser = false,
            isLoading = false,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatBubbleLongPreview() {
    PreviewBox {
        ChatBubble(
            content = "This is a long preview chat message! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque tristique nisl non dolor cursus, ac blandit sem vehicula. Praesent in orci ac eros vulputate scelerisque at vel urna. Nullam dolor arcu, tempus vel posuere sed, dictum in arcu. Aliquam in dui vehicula, tristique lorem sit amet, volutpat tortor. Etiam auctor non nunc et imperdiet. Suspendisse potenti. Etiam laoreet mi nec libero facilisis, eget rutrum nisi tincidunt. Maecenas tristique sapien vel felis porta viverra. Maecenas auctor lorem nibh, sed vestibulum orci euismod vitae. Nullam auctor dolor vitae euismod fringilla. Quisque enim odio, rutrum in mi at, sodales tristique turpis. Mauris vestibulum arcu vel velit dapibus, eu congue odio maximus. Quisque molestie venenatis euismod.",
            isUser = false,
            isLoading = false,
        )
    }
}