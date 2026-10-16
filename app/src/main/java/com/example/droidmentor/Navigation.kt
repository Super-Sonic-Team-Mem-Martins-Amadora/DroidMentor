package com.example.droidmentor

sealed class Navigation(val route: String) {
    data object Chat : Navigation("chat") {
        fun createRoute(chatIndex: Int): String = "chat/${chatIndex}"
    }
    data object NewChat : Navigation("newChat")
    data object AllChats : Navigation("allChats")
    data object Sidebar : Navigation("sidebar")
    data object Settings : Navigation("settings")
    data object About : Navigation("about")
}