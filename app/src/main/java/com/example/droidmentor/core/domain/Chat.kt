package com.example.droidmentor.core.domain

import java.time.LocalDateTime

class Chat(
    val messages: MutableList<Msg> = mutableListOf<Msg>(),
    val title: String = "New Chat",
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val lastDateModified: LocalDateTime? = null
) {

}

data class Msg(val content: String, val account: Account)