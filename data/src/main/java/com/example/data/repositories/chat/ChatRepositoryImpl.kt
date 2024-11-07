package com.example.data.repositories.chat

import com.example.domain.entities.ChatRoom
import com.example.domain.repositories.ChatRemoteDataSource
import com.example.domain.repositories.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatRemoteDataSource: ChatRemoteDataSource
) : ChatRepository {
    override fun addRoom(room: ChatRoom, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        chatRemoteDataSource.addRoom(room, onSuccess, onFailure)
    }
}