package com.example.domain.repositories

import com.example.domain.entities.ChatRoom

interface ChatRepository {
    fun addRoom(
        room : ChatRoom,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )
}

interface ChatRemoteDataSource{
    fun addRoom(
        room : ChatRoom,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )
}