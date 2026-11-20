package com.example.droidmentor.ui.viewmodels.viewmodelstates

import com.example.droidmentor.core.domain.Chat

sealed class sidebarState {

    data object Loading : sidebarState()

    data class Content(
        val chatList: List<Chat>
    ) : sidebarState()

    data class Error(
        val error: Throwable
    ) : sidebarState()
}