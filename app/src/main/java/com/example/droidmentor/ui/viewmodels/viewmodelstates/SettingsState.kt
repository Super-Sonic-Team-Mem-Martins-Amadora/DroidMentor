package com.example.droidmentor.ui.viewmodels.viewmodelstates

sealed class SettingsState {
    data object Content : SettingsState()

    data object Loading : SettingsState()

    data class Error(
        val error: Throwable
    ) : SettingsState()
}