package com.example.droidmentor.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.repositories.ChatRepository
import com.example.droidmentor.ui.viewmodels.viewmodelstates.SidebarState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class SidebarViewModel (
    private val chatRepository: ChatRepository
) : ViewModel() {

    val state: StateFlow<SidebarState> = chatRepository.getChats(10)
        .map<List<Chat>, SidebarState> { SidebarState.Content(it) }
        .catch { emit(SidebarState.Error(it))  }
        .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SidebarState.Loading
    )

    companion object {
        fun factory (
            chatRepository: ChatRepository
        ): ViewModelProvider.Factory =
            viewModelFactory {
                initializer {
                    SidebarViewModel(chatRepository)
                }
            }
    }
}