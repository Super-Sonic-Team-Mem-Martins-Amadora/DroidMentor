package com.example.droidmentor.ui.screens

import android.util.Log
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.droidmentor.R
import com.example.droidmentor.core.domain.Account
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.domain.Msg
import com.example.droidmentor.ui.components.ChatInput
import com.example.droidmentor.ui.components.Conversation
import com.example.droidmentor.ui.components.DroidIcon
import com.example.droidmentor.ui.components.Header
import com.example.droidmentor.ui.components.IconButton
import com.example.droidmentor.ui.components.Logo
import com.example.droidmentor.ui.theme.DroidMentorTheme
import com.example.droidmentor.ui.theme.comicSansFamily
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun ChatScreen(
    onSend: (String) -> Unit = {},
    conversation: Chat = Chat(),
){
    val messages by remember {
        derivedStateOf {
            conversation.messages
        }
    }

    val newChat = messages.isEmpty()

    val logosAlpha by animateFloatAsState(
        targetValue = if (newChat) 1f else 0f,
        animationSpec = tween(durationMillis = 500, easing = EaseInOutCubic),
        label = "logosFade"
    )

    fun getInvertedLogosAlpha(): Float {
        return -(logosAlpha - 1f)
    }

    var click by remember { mutableIntStateOf(0) }
    val uriHandler = LocalUriHandler.current
    val logo = @Composable {
        Icon(
            painter = painterResource(R.drawable.logo),
            contentDescription = "DroidMentor",
            tint = Color.Unspecified,
            modifier = Modifier.size(50.dp)
                .clickable(
                    interactionSource = null,
                    indication = null,
                ) {
                    click++
                    if (click >= 15) {
                        click = 0
                        val url = "https://www.youtube.com/watch?v=szby7ZHLnkA"
                        uriHandler.openUri(url)
                    }
                }
                .graphicsLayer { alpha = getInvertedLogosAlpha() }
        )
    }

    val inputPlaceholder = @Composable {
        Text(
            text = "Ask anything...",
            style = MaterialTheme.typography.bodyMedium
        )
    }

    val header = @Composable {
        Header(
            button = {
                IconButton(
                    icon = {
                        DroidIcon(
                            iconFile = R.drawable.burger,
                            iconSize = 50.dp,
                            iconDesc = "Sidebar"
                        )
                    },
                    onClick = {

                    }
                )
            },
            icon = if (getInvertedLogosAlpha() != 0f) logo else null,
            modifier = Modifier.padding(15.dp).padding(horizontal = 5.dp)
        )
    }

    Scaffold(
        topBar = header,
        //containerColor = Color.Black,
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (!newChat) {
                Conversation(
                    conversation,
                    bottom = {
                        Box(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "DroidMentor can make mistakes. Please double-check responses.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.surfaceDim,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.align(alignment = Alignment.TopCenter)
                            )
                            Spacer(modifier = Modifier.height(125.dp))
                        }
                    },
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
            if (logosAlpha != 0f) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .graphicsLayer { alpha = logosAlpha }
                ) {
                    Column {
                        Spacer(Modifier.height(30.dp))
                        Logo(
                            label = {
                                Box {
                                    Text(
                                        text = "DroidMentor",
                                        style = TextStyle(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            fontFamily = comicSansFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 52.sp,
                                            lineHeight = 24.sp,
                                            letterSpacing = 0.5.sp
                                        ),
                                    )
                                    Text(
                                        text = "DroidMentor",
                                        style = TextStyle(
                                            color = MaterialTheme.colorScheme.primary,
                                            drawStyle = Stroke(
                                                width = 7f
                                            ),
                                            fontFamily = comicSansFamily,
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 52.sp,
                                            lineHeight = 24.sp,
                                            letterSpacing = 0.5.sp
                                        ),
                                    )
                                }
                            }
                        )
                    }
                }
            }
            ChatInput(
                onSend = { msg ->
                    Log.d("CHAT", msg)
                    onSend(msg)
                },
                placeholder = if (newChat) inputPlaceholder else null,
                modifier = Modifier
                    .padding(15.dp)
                    .height(90.dp)
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Preview
@Composable
fun ChatScreenPreview() {

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
        "I'm not ChatGPT so I'm unable to assist you but I will see what I can do, try again later.",
        "ok chat gippidy, thank you chat chippidy",
        "Its not a problem! If you need anything else, dont hesitate to ask!"
    )

    val aiMSG = listOf(
        "I'm sorry, im unable to assist with your request.",
        "Can you please try again?",
        "Try again later.",
        "Service Unavailable",
        "undefined",
        "no",
        "I don't know what you mean, please rephrase.",
        "I'm unable to assist with that."
    )

    val msgs = remember { mutableStateListOf<Msg>() }

    messages.forEachIndexed { i, msg ->
        msgs.add(Msg(msg, if (i % 2 == 0) user else ai))
    }

    val chat = Chat(
        title = "Chat Screen Example",
        messages = msgs,
        createdDate = LocalDateTime.now(),
        lastDateModified = LocalDateTime.now()
    )

    val scope = rememberCoroutineScope()

    DroidMentorTheme {
        ChatScreen(
            {
                chat.messages.add(
                    Msg(it, user)
                )
                scope.launch {
                    delay(1500.milliseconds)
                    chat.messages.add(Msg(aiMSG.random(), ai))
                }

            },
            chat
        )
    }
}

@Preview
@Composable
fun NoChatScreenPreview() {

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

    val aiMSG = listOf(
        "I'm sorry, im unable to assist with your request.",
        "Can you please try again?",
        "Try again later.",
        "Service Unavailable",
        "undefined",
        "no",
        "I don't know what you mean, please rephrase.",
        "I'm unable to assist with that."
    )

    val msgs = remember { mutableStateListOf<Msg>() }

    val chat = Chat(
        title = "Chat Screen Example",
        messages = msgs,
        createdDate = LocalDateTime.now(),
        lastDateModified = LocalDateTime.now()
    )

    val scope = rememberCoroutineScope()

    DroidMentorTheme {
        ChatScreen(
            {
                chat.messages.add(
                    Msg(it, user)
                )
                scope.launch {
                    delay(1500.milliseconds)
                    chat.messages.add(Msg(aiMSG.random(), ai))
                }

            },
            chat
        )
    }
}