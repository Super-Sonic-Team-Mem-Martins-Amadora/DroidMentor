package com.example.droidmentor.core.domain

import java.time.LocalDateTime

class Chat(
    val messages: MutableList<Msg>
) {

}

data class Msg(val content: String, val date: LocalDateTime, val account: Account)