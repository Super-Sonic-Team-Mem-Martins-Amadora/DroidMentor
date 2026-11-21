package com.example.droidmentor.ui.ViewModels

import android.content.ClipData
import android.content.ClipboardManager
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.droidmentor.core.domain.Account
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.domain.Msg
import com.example.droidmentor.ui.viewmodels.viewmodelstates.ChatScreenState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class ChatViewModel() : ViewModel() {

    var ball = mutableStateOf(false)

    val state: StateFlow<ChatScreenState>
        get() {
            ChatScreenState.Loading
        }

    val clipboard = context.getSystemService(ClipboardManager::class.java)
    val conversation: Chat = Chat()

    fun onSend(message: String) {
        if (ball) eightBall(message, conversation, scope) else {
            viewModel.onSend(message)
        }
    }
    fun onRefresh(messageId: Int) {

    }
    fun canCopyMessage(messageId: Int): Boolean {
        return !conversation.messages[messageId].account.isUser
    }
    fun copyText(name: String, text: String) {
        val clip = ClipData.newPlainText(name, text)
        clipboard.setPrimaryClip(clip)
    }

    fun ballClick() {
        click++
        if (click < 20) return@clickable
        if (click == 20) {
            ball = true
        }
        click = 0
    }

    private fun eightBall(msg: String, chat: Chat) {
        chat.messages.add(
            Msg(msg, Account("sonic", "Sonic", true))
        )
        val aiMSG = listOf("Reply hazy try again.", "Ask again later.", "Better not tell you now.", "Cannot predict now.", "Go for it!", "You will have to wait.", "Ask again later.", "Concentrate and ask again.", "Never going to happen!", "The odds of that happening are pretty slim.", "My reply is no.", "My sources say no.", "Very doubtful.", "No.", "I have no response for that question...", "Why would I tell you?", "Forget about it.", "Don't bet on it.", "Who knows?", "Without a doubt.", "You may rely on it.", "Outlook good.", "Probably.", "Most likely.", "This is not the Bot you're looking for ༼ﾉ۞⌂۞༽ﾉ", "There's a pretty good chance.", "No, don't even think about.", "Yes, in due time.", "It is certain.", "Signs point to yes.", "Yes definitely.", "As I see it, yes.", "Yes.", "Signs point to yes.")
        viewModelScope.launch {
            delay(1500.milliseconds)
            chat.messages.add(Msg(aiMSG.random(), Account("ai", "8Ball", false)))
        }
    }

    companion object {

        fun factory(
            clipboard: ClipboardManager,

        ): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    ChatScreenViewModel()
                }
            }
    }
}