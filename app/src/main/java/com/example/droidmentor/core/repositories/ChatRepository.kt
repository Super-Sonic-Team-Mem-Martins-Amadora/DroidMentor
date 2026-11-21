package com.example.droidmentor.core.repositories

import com.example.droidmentor.core.domain.Chat
import com.example.droidmentor.core.repositories.interfaces.ChatRepositoryInterface
import kotlinx.coroutines.flow.Flow

class ChatRepository(): ChatRepositoryInterface {

    override fun getChats(nOfChats: Int): Flow<List<Chat>> {
        TODO("Not yet implemented")
    }
}