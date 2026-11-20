package com.example.droidmentor.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.droidmentor.core.repositories.ChatRepository
import com.example.droidmentor.ui.viewmodels.viewmodelstates.sidebarState
import kotlinx.coroutines.flow.StateFlow

class SidebarViewModel (
    private val repository: ChatRepository
) : ViewModel() {

    // falta funcoes do repo
    val state: StateFlow<sidebarState>
        get() {
            TODO()
        }

    // funcoes do viewModle

    // factory para criar viewmodel
}