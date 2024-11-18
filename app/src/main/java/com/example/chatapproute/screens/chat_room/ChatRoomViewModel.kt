package com.example.chatapproute.screens.chat_room

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Message
import com.example.domain.usecases.chat_usecaes.ChatUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatRoomViewModel @Inject constructor(
    private val chatUseCases: ChatUseCases
): ViewModel() {
    val messageState = mutableStateOf("")
    val chatMessagesState : SnapshotStateList<Message> = mutableStateListOf()

    fun onEvent(event : ChatRoomScreenEvents){
        when(event){
            is ChatRoomScreenEvents.SendMessage -> {
                sendMessage(event.message)
            }

            is ChatRoomScreenEvents.GetMessages -> {
                getMessages(event.roomID)
            }
        }
    }

    private fun sendMessage(message : Message){
        chatUseCases.sendMessageUseCase(
            message,
            onSuccess = {
                Log.e("FIB FireStore" , "ViewModel : Message sent")
                messageState.value = ""
            },
            onFailure = {
                Log.e("FIB" , "ViewModel Error : ${it.message}")
            }
        )
    }

    private fun getMessages(
        roomID : String,
    ){
        viewModelScope.launch {
            chatUseCases.getMessagesUseCase(
                roomID,
                onSuccess = {
                    chatMessagesState.clear()
                    chatMessagesState.addAll(it)
                    Log.e("FIB FireStore" , "ViewModel : messages retrieved")
                },
                onFailure = {
                    Log.e("FIB FireStore" , "ViewModelError : ${it.message}")
                }
            )
        }
    }
}