package com.example.droidmentor.ui.components

import android.content.ClipData
import android.content.ClipboardManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import com.example.droidmentor.ui.theme.AppTheme


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
            tint = AppTheme.colors.loadingMessage
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = "Loading...",
            style = MaterialTheme.typography.bodySmall,
            color = AppTheme.colors.loadingMessage
        )
    }
}

@Composable
fun ChatBubble(
    content: String,
    isUser: Boolean,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    author: String? = null,
){
    val context = LocalContext.current
    val clipboard = context.getSystemService(ClipboardManager::class.java)
    val canCopy = !isUser

    val backgroundBubbleColor = if (isUser) {
        AppTheme.colors.userTextContainer
    } else {
        AppTheme.colors.AITextContainer
    }
    val borderBubbleColor = if (isUser) {
        AppTheme.colors.userTextContainerBorder
    } else {
        AppTheme.colors.AITextContainerBorder
    }

    val textBubbleColor = if (isUser) {
        AppTheme.colors.UserText
    } else {
        AppTheme.colors.AIText
    }

    val subtextBubbleColor = if (isUser) {
        AppTheme.colors.subtitleText
    } else {
        AppTheme.colors.AITextContainerBorder
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
                color = subtextBubbleColor
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
            return
        }
        if (canCopy) {
            Spacer(Modifier.height(3.dp))
            Row(
                modifier = Modifier.height(IntrinsicSize.Min)
            ) {
                Spacer(Modifier.width(3.dp))
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.copy,
                            iconSize = 25.dp,
                            iconDesc = "Copy"
                        )
                    },
                    onClick = {
                        val clip = ClipData.newPlainText("AI Message", content)
                        clipboard.setPrimaryClip(clip)
                    },
                    modifier = Modifier.size(40.dp)
                )
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.refresh,
                            iconSize = 25.dp,
                            iconDesc = "Refresh"
                        )
                    },
                    onClick = {

                    },
                    modifier = Modifier.size(40.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun UserChatBubblePreview() {
    PreviewBox(dark = true) {
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
    PreviewBox (dark = true){
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