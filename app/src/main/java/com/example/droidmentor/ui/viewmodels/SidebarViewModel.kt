package com.example.droidmentor.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.repositories.ChatRepository
import com.example.droidmentor.ui.viewmodels.viewmodelstates.SidebarState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class SidebarViewModel (
    private val chatRepository: ChatRepository
) : ViewModel() {

    private enum class Trigger { Start, Retry }

    private val triggers = MutableSharedFlow<Trigger>(extraBufferCapacity = 1)

    val state: StateFlow<SidebarState> = triggers
        .onStart { emit(Trigger.Start) }
        .flatMapLatest { trigger ->
            chatRepository.getChats(10)
            .map<List<Chat>, SidebarState> { SidebarState.Content(it) }

            .onStart { if (trigger == Trigger.Retry) emit(SidebarState.Loading) }
            .catch { emit(SidebarState.Error(it))  }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = SidebarState.Loading
        )

    fun onRetry() {
        if (state.value is SidebarState.Error)
            triggers.tryEmit(Trigger.Retry)
    }

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