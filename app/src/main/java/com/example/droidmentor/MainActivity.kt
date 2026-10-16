package com.example.droidmentor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.ui.screens.ChatScreen
import com.example.droidmentor.ui.theme.DroidMentorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DroidMentorTheme {
                val navController = rememberNavController()

                val conversations = remember { mutableStateListOf<Chat>() }

                NavHost(navController, startDestination = Navigation.NewChat.route) {
                    composable(Navigation.NewChat.route) {
                        ChatScreen(
                            conversation = Chat().also { conversations.add(it) }
                        )
                    }

                }

            }
        }
    }
}
