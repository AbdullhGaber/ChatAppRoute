package com.example.chatapproute.screens.add_room

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.example.data.util.Resource
import kotlinx.coroutines.flow.asStateFlow

data class AddRoomScreenStates(
    val roomNameState : MutableState<String> = mutableStateOf(""),
    val roomNameError : MutableState<String> = mutableStateOf(""),
    val selectedRoomState : MutableState<Int> = mutableIntStateOf(0),
    val roomDescription : MutableState<String> = mutableStateOf(""),
    val roomDescriptionError : MutableState<String> = mutableStateOf(""),
    val isDropMenuExpanded : MutableState<Boolean> = mutableStateOf(false),
    val addRoomStateFlow : State<Resource<Unit>> = mutableStateOf(Resource.Unspecified())
)
