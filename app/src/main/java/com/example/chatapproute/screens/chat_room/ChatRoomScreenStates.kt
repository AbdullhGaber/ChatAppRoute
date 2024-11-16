package com.example.chatapproute.screens.chat_room

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ChatRoomScreenStates(
    val messageState : MutableState<String> = mutableStateOf("")
)