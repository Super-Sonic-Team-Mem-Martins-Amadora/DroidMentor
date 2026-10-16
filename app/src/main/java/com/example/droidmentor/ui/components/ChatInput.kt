package com.example.droidmentor.ui.components

import android.graphics.Paint
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.EaseInOutBounce
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R

@Composable
fun ChatInput(
    modifier: Modifier = Modifier,
    onSend: (String) -> Unit = {},
    placeholder: @Composable (() -> Unit)? = null,
) {
    var chatInput by remember { mutableStateOf("") }

    val sendAlpha by animateFloatAsState(
        targetValue = if (chatInput.isNotEmpty()) 1f else 0f,
        animationSpec = tween(durationMillis = 150, easing = EaseInOutCubic),
        label = "sendFade"
    )

    Surface(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(3.dp, color = MaterialTheme.colorScheme.primary),
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                placeholder = placeholder,
                value = chatInput,
                onValueChange = {
                    chatInput = it
                },

                textStyle = MaterialTheme.typography.bodyMedium,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                ),
                modifier = Modifier.fillMaxWidth().weight(0.8f)
            )
            if (sendAlpha != 0f) {
                Button(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .aspectRatio(1f)
                        .weight(0.2f)
                        .graphicsLayer(alpha = sendAlpha),
                    contentPadding = PaddingValues(5.dp),
                    onClick = {
                        onSend(chatInput)
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.send),
                        contentDescription = "Send",
                        tint = MaterialTheme.colorScheme.primaryContainer,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun ChatInputPreview() {
    PreviewBox {
        ChatInput(
            modifier = Modifier.height(90.dp).fillMaxWidth()
        )
    }
}