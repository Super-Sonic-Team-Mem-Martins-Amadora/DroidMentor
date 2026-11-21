package com.example.droidmentor.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutCredits(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    border: BorderStroke? = null,
    avatar: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,   // trailing icon (GitHub)
) {
    Surface(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 72.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.tertiaryContainer,
        border = border ?: BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            // Left group: avatar + name
            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (avatar != null) {
                    avatar()
                    Spacer(modifier = Modifier.width(8.dp))
                }
                Text(
                    text = label,
                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 23.sp,
                    textAlign = TextAlign.Start,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            // Right: icon
            if (icon != null) {
                Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
                icon()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutCreditsPreviewIcons() {
    PreviewBox(dark = true) {
        Column(
            modifier = Modifier.padding(10.dp, 0.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            // Without icon
            AboutCredits(
                label = "No icon",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )

            // With icon
            AboutCredits(
                label = "Icon",
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                icon = {
                    Box(
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                            .background(Color.Magenta)
                    )
                },
                avatar = {
                    Box(
                        modifier = Modifier
                            .size(ButtonDefaults.IconSize)
                            .background(Color.Magenta)
                    )
                }
            )
        }
    }
}