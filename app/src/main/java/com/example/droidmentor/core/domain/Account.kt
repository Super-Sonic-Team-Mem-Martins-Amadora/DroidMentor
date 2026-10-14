package com.example.droidmentor.core.domain

class Account(
    val username: String,
    val displayName: String,
    val isUser: Boolean,
    val email: String? = null,
    val hash: String? = null,
) {



}