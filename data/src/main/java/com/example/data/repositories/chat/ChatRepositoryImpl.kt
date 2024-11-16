package com.example.data.repositories.chat

import com.example.domain.entities.ChatRoom
import com.example.domain.entities.Message
import com.example.domain.repositories.ChatRemoteDataSource
import com.example.domain.repositories.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val chatRemoteDataSource: ChatRemoteDataSource
) : ChatRepository {
    override fun addRoom(room: ChatRoom, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        chatRemoteDataSource.addRoom(room, onSuccess, onFailure)
    }

    override fun getRooms(onSuccess: (List<ChatRoom>) -> Unit, onFailure: (Throwable) -> Unit) {
        chatRemoteDataSource.getRooms(onSuccess, onFailure)
    }

    override fun joinRoom(
        roomID: String,
        uid: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        chatRemoteDataSource.joinRoom(roomID, uid, onSuccess, onFailure)
    }

    override fun sendMessage(
        message: Message,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        chatRemoteDataSource.sendMessage(message, onSuccess, onFailure)
    }
}