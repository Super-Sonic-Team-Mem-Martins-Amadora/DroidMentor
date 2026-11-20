package com.example.droidmentor.ui.ViewModels

import android.content.ClipData
import android.content.ClipboardManager
import androidx.lifecycle.ViewModel
import com.example.droidmentor.core.domain.Chat

class ChatViewModel() : ViewModel() {
    val clipboard = context.getSystemService(ClipboardManager::class.java)
    val conversation: Chat = Chat()

    fun onSend(message: String) {

    }
    fun onRefresh(messageId: Int) {

    }
    fun canCopyMessage(messageId: Int): Boolean {
        return !conversation.messages[messageId].account.isUser
    }
    fun copyText(name: String, text: String) {
        val clip = ClipData.newPlainText(name, text)
        clipboard.setPrimaryClip(clip)
    }









}