package com.example.droidmentor.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.droidmentor.R
import java.time.Duration
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

@Composable
fun ChatButton(
    chatTitle: String,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    lastDateModified: LocalDateTime? = null
){

    var currTime = ""

    if (lastDateModified != null) {
        val now = LocalDateTime.now()

        val minutes = ChronoUnit.MINUTES.between(lastDateModified, now)
        val hours = ChronoUnit.HOURS.between(lastDateModified, now)
        val days = ChronoUnit.DAYS.between(lastDateModified, now)
        val months = ChronoUnit.MONTHS.between(lastDateModified, now)
        val years = ChronoUnit.YEARS.between(lastDateModified, now)

        currTime = when {
            minutes < 1 -> "just now"
            hours < 1 -> "$minutes minutes ago"
            days < 1 -> "$hours hours ago"
            days < 2 -> "Yesterday"
            months < 1 -> "$days days ago"
            years < 1 -> "$months moths ago"
            else -> lastDateModified.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        }
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        modifier = modifier
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon()
            Spacer(modifier.width(8.dp))
            Column {
                Text(
                    text = chatTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                if (lastDateModified != null) {
                    Text(
                        text = currTime,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewInstantNow(){
    PreviewBox(dark = true) {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
            lastDateModified = LocalDateTime.now()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewInstantMinutes(){
    PreviewBox {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
            lastDateModified = LocalDateTime.now().minus(Duration.ofMinutes(2))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewInstantHours(){
    PreviewBox {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
            lastDateModified = LocalDateTime.now().minus(Duration.ofHours(1))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewInstantYesterday(){
    PreviewBox {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
            lastDateModified = LocalDateTime.now().minus(Duration.ofDays(1))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewInstantDays(){
    PreviewBox {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
            lastDateModified = LocalDateTime.now().minus(Duration.ofDays(2))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewInstantMonths(){
    PreviewBox {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
            lastDateModified = LocalDateTime.now().minus(Duration.ofDays(40))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewOld(){
    PreviewBox {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
            lastDateModified = LocalDateTime.now().minus(Duration.ofDays(400))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ChatButtonPreviewWithoutTimestamp(){
    PreviewBox {
        ChatButton(
            "Chat Button",
            onClick = {},
            icon = {
                DroidIcon(
                    iconFile = R.drawable.chat,
                    iconSize = 32.dp
                )
            },
        )
    }
}