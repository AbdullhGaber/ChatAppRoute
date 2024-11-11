package com.example.chatapproute.screens.join_room

sealed class JoinRoomScreenEvents {
    data class JoinRoom(
        val roomID: String,
        val uid: String,
        val onSuccess: () -> Unit,
    ) : JoinRoomScreenEvents()
}