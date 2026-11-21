package com.example.droidmentor.ui.viewmodels.viewmodelstates

import com.example.droidmentor.core.domain.Chat
import kotlinx.coroutines.flow.StateFlow

sealed class ChatScreenState {

    data object Loading : ChatScreenState()

    data class Chatting(
        val conversation: List<Chat>,
        val chattingState: StateFlow<ChattingState>
    ) : ChatScreenState()

    data class Error(
        val error: Throwable
    ) : ChatScreenState()
}