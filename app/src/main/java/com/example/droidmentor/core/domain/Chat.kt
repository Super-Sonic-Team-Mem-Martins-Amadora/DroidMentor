package com.example.droidmentor.core.domain

import java.time.LocalDateTime

class Chat(
    val messages: MutableList<Msg>,
    val date: LocalDateTime
) {

}

data class Msg(val content: String, val account: Account)