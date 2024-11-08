package com.example.domain.repositories

import com.example.domain.entities.ChatRoom

interface ChatRepository {
    fun addRoom(
        room : ChatRoom,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )

    fun getRooms(
        onSuccess : (List<ChatRoom>) -> Unit,
        onFailure : (Throwable) -> Unit
    )
}

interface ChatRemoteDataSource{
    fun addRoom(
        room : ChatRoom,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )

    fun getRooms(
        onSuccess : (List<ChatRoom>) -> Unit,
        onFailure : (Throwable) -> Unit
    )
}