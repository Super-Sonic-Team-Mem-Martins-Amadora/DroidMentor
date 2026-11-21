package com.example.droidmentor.ui.viewmodels.viewmodelstates

import com.example.droidmentor.core.domain.Chat
import kotlinx.coroutines.flow.StateFlow

sealed class ChattingState {

    data object Texting : ChattingState()

    data object Waiting : ChattingState()

    data class Error(
        val error: Throwable
    ) : ChattingState()
}