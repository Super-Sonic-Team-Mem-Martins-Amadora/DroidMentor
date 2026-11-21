package com.example.droidmentor.ui.viewmodels.viewmodelstates

import com.example.droidmentor.core.domain.Chat

sealed class SidebarState {

    data object Loading : SidebarState()

    data class Content(
        val chatList: List<Chat>
    ) : SidebarState()

    data class Error(
        val error: Throwable
    ) : SidebarState()
}