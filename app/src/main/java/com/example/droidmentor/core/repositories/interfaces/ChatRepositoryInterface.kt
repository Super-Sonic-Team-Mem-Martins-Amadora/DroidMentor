package com.example.droidmentor.core.repositories.interfaces

import com.example.droidmentor.core.domain.Chat
import kotlinx.coroutines.flow.Flow

interface ChatRepositoryInterface {

    fun getChats(nOfChats: Int): Flow<List<Chat>>

}