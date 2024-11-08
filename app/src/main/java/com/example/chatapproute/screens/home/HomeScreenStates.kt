package com.example.chatapproute.screens.home

import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.example.data.util.Resource
import com.example.domain.entities.ChatRoom
import kotlinx.coroutines.flow.asStateFlow

data class HomeScreenStates(
    val roomsStateFlow : State<Resource<List<ChatRoom>>> = mutableStateOf(Resource.Unspecified()),
    val tabRowSelectedIndex : MutableIntState = mutableIntStateOf(0)
)
