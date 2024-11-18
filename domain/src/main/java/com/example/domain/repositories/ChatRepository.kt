package com.example.domain.repositories

import com.example.domain.entities.ChatRoom
import com.example.domain.entities.Message

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

    fun joinRoom(
        roomID : String,
        uid : String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )

    fun sendMessage(
        message : Message,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    )

    fun getMessages(
        roomID: String,
        onSuccess: (List<Message>) -> Unit,
        onFailure: (Throwable) -> Unit
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

    fun joinRoom(
        roomID : String,
        uid : String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )

    fun sendMessage(
        message : Message,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    )

    fun getMessages(
        roomID: String,
        onSuccess: (List<Message>) -> Unit,
        onFailure: (Throwable) -> Unit
    )
}