package com.example.droidmentor.core.domain

import java.time.LocalDateTime

class Chat(
    val messages: MutableList<Msg>,
    val title: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val lastDateModified: LocalDateTime
) {

}

data class Msg(val content: String, val account: Account)