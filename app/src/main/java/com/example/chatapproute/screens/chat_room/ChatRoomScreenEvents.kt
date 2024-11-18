package com.example.chatapproute.screens.chat_room

import com.example.domain.entities.Message

sealed class ChatRoomScreenEvents {
    data class SendMessage(val message : Message) : ChatRoomScreenEvents()
    data class GetMessages(val roomID : String) : ChatRoomScreenEvents()
}