package com.example.droidmentor.ui.viewmodels.viewmodelstates

sealed class AboutState {
    data object Content : AboutState()

    data object Loading : AboutState()

    data class Error(
        val error: Throwable
    ) : AboutState()
}