package com.example.chatapproute.screens.chat_room

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.domain.entities.Message
import com.example.domain.usecases.chat_usecaes.ChatUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatRoomViewModel @Inject constructor(
    private val chatUseCases: ChatUseCases
): ViewModel() {
    val messageState = mutableStateOf("")

    fun onEvent(event : ChatRoomScreenEvents){
        when(event){
            is ChatRoomScreenEvents.SendMessage -> {
                sendMessage(event.message)
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

}