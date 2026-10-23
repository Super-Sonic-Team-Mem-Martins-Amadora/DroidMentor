package com.example.droidmentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.droidmentor.core.domain.Account
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.domain.Msg
import com.example.droidmentor.ui.screens.About
import com.example.droidmentor.ui.screens.AllChats
import com.example.droidmentor.ui.screens.ChatScreen
import com.example.droidmentor.ui.screens.Easter
import com.example.droidmentor.ui.screens.Settings
import com.example.droidmentor.ui.screens.Sidebar
import com.example.droidmentor.ui.theme.DroidMentorTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DroidMentorTheme {

                val navController = rememberNavController()

                val conversations = remember { mutableStateListOf<Chat>() }

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

                val aiMSG = listOf("Reply hazy try again.", "Ask again later.", "Better not tell you now.", "Cannot predict now.", "Go for it!", "You will have to wait.", "Ask again later.", "Concentrate and ask again.", "Never going to happen!", "The odds of that happening are pretty slim.", "My reply is no.", "My sources say no.", "Very doubtful.", "No.", "I have no response for that question...", "Why would I tell you?", "Forget about it.", "Don't bet on it.", "Who knows?", "Without a doubt.", "You may rely on it.", "Outlook good.", "Probably.", "Most likely.", "This is not the Bot you're looking for ༼ﾉ۞⌂۞༽ﾉ", "There's a pretty good chance.", "No, don't even think about.", "Yes, in due time.", "It is certain.", "Signs point to yes.", "Yes definitely.", "As I see it, yes.", "Yes.", "Signs point to yes.")

                var draft by remember { mutableStateOf(Chat()) }

                NavHost(
                    navController,
                    startDestination = Navigation.NewChat.route,
                    modifier = Modifier.background(MaterialTheme.colorScheme.background),
                    ) {
                    composable(
                        Navigation.NewChat.route) {

                        val scope = rememberCoroutineScope()

                        ChatScreen(
                            conversation = draft,
                            onOpenSidebar = {
                                navController.navigate(Navigation.Sidebar.route) {
                                    launchSingleTop = true
                                }
                            },
                            onSend = {
                                val chat = draft
                                if (conversations.none { c -> c === chat }) {
                                    conversations.add(chat)
                                    chat.title = it
                                }
                                chat.lastDateModified = LocalDateTime.now()
                                chat.messages.add(
                                    Msg(it, user)
                                )
                                scope.launch {
                                    delay(1500.milliseconds)
                                    chat.messages.add(Msg(aiMSG.random(), ai))
                                }
                            }
                        )
                    }
                    composable(Navigation.Chat.route, arguments = listOf(
                        navArgument("chatIndex") {
                            type = NavType.IntType
                        }
                    )) { backStackEntry ->
                        val index = backStackEntry.arguments?.getInt("chatIndex") ?: return@composable
                        val chat = conversations.getOrNull(index) ?: return@composable
                        val scope = rememberCoroutineScope()
                        ChatScreen(
                            conversation = chat,
                            onOpenSidebar = {
                                navController.navigate(Navigation.Sidebar.route) {
                                    launchSingleTop = true
                                }
                            },
                            onSend = {
                                chat.messages.add(
                                    Msg(it, user)
                                )
                                chat.lastDateModified = LocalDateTime.now()
                                scope.launch {
                                    delay(1500.milliseconds)
                                    chat.messages.add(Msg(aiMSG.random(), ai))
                                }
                            }
                        )
                    }
                    composable(Navigation.AllChats.route) {
                        AllChats(
                            chatList = conversations,
                            onOpenSidebar = {
                                navController.navigate(Navigation.Sidebar.route) {
                                    popUpTo(Navigation.AllChats.route) {
                                        inclusive = true
                                    }
                                }
                            },
                            onOpenNewChat = {
                                draft = Chat()
                                navController.navigate(Navigation.NewChat.route) {
                                    popUpTo(Navigation.Chat.route) {
                                        inclusive = true
                                    }
                                }
                            },
                            onOpenChat = { id ->
                                navController.navigate(Navigation.Chat.createRoute(id)) {
                                    popUpTo(Navigation.Chat.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                    composable(
                        Navigation.Sidebar.route,
                        enterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { -it },
                                animationSpec = tween(durationMillis = 700)
                            )},
                        exitTransition = { slideOutHorizontally(
                            targetOffsetX  = { -it },
                            animationSpec = tween(durationMillis = 700)
                        )}) {
                        Sidebar(
                            chatList = conversations,
                            onCloseSidebar = {
                                navController.safePopBackStack()
                            },
                            onOpenNewChat = {
                                draft = Chat()
                                navController.navigate(Navigation.NewChat.route) {
                                    popUpTo(Navigation.Chat.route) {
                                        inclusive = true
                                    }
                                }
                            },
                            onOpenSettings = {
                                navController.navigate(Navigation.Settings.route) {
                                    launchSingleTop = true
                                }
                            },
                            onOpenAllChats = {
                                navController.navigate(Navigation.AllChats.route) {
                                    popUpTo(Navigation.Sidebar.route) {
                                        inclusive = true
                                    }
                                }
                            },
                            onOpenChat = { id ->
                                navController.navigate(Navigation.Chat.createRoute(id)) {
                                    popUpTo(Navigation.Chat.route) {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                    composable(Navigation.About.route) {
                        About(
                            onBack = {
                                navController.safePopBackStack()
                            }
                        )
                    }
                    composable(
                        Navigation.Settings.route,
                        enterTransition = { slideInVertically(
                            initialOffsetY = { it },
                            animationSpec = tween(700)
                        )},
                        exitTransition = { slideOutVertically(
                                targetOffsetY = { it },
                                animationSpec = tween(700)
                            )
                        }) {
                        Settings(
                            onBack = {
                                navController.safePopBackStack()
                            },
                            onEasterEgg = {
                                navController.navigate(Navigation.Easter.route) {
                                    launchSingleTop = true
                                }
                            },
                            onOpenAbout = {
                                navController.navigate(Navigation.About.route) {
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                    composable(
                        Navigation.Easter.route,
                        enterTransition = { scaleIn(tween(1000)) },
                        exitTransition = { scaleOut(tween(1000)) }) {
                        Easter(
                            onBack = {
                                navController.safePopBackStack()
                            }
                        )
                    }
                }

            }
        }
    }
}
