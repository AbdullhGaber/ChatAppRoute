package com.example.chatapproute.screens.add_room

import com.example.domain.entities.ChatRoom

sealed class AddRoomScreenEvents{
    data class AddRoom(val room : ChatRoom, val onSuccess : () -> Unit) : AddRoomScreenEvents()
}