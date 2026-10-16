package com.example.droidmentor.core.domain

import androidx.compose.runtime.mutableStateListOf
import java.time.LocalDateTime

class Chat(
    val messages: MutableList<Msg> = mutableStateListOf<Msg>(),
    val title: String = "New Chat",
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val lastDateModified: LocalDateTime? = null
) {

}

data class Msg(val content: String, val account: Account)