package com.example.chatapproute.screens.join_room

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.data.util.Resource

data class JoinRoomStates(
    val joinRoomStateFlow : State<Resource<Unit>> = mutableStateOf(Resource.Unspecified())
)
