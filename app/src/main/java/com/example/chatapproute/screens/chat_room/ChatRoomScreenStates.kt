package com.example.chatapproute.screens.chat_room

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.domain.entities.Message

data class ChatRoomScreenStates(
    val messageState : MutableState<String> = mutableStateOf(""),
    val chatMessagesState : SnapshotStateList<Message> = mutableStateListOf()
)