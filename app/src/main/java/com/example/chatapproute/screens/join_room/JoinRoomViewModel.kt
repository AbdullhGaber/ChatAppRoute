package com.example.chatapproute.screens.join_room

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.util.Resource
import com.example.domain.usecases.chat_usecaes.ChatUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinRoomViewModel @Inject constructor(
    private val chatUseCases: ChatUseCases
) : ViewModel() {
    private val _joinRoomStateFlow = MutableStateFlow<Resource<Unit>>(Resource.Unspecified())
    val joinRoomStateFlow = _joinRoomStateFlow.asStateFlow()

    fun onEvent(event : JoinRoomScreenEvents){
        when(event){
            is JoinRoomScreenEvents.JoinRoom -> {
                joinRoom(
                    roomID = event.roomID,
                    uid = event.uid,
                    onSuccess = event.onSuccess
                )
            }
        }
    }

    private fun joinRoom(
        roomID : String,
        uid : String,
        onSuccess : () -> Unit
    ){
        viewModelScope.launch {
            _joinRoomStateFlow.emit(Resource.Loading())
            chatUseCases.joinRoomUseCase(
                roomID = roomID,
                uid = uid,
                onSuccess = {
                    viewModelScope.launch {
                        _joinRoomStateFlow.emit(Resource.Success(data = Unit))
                    }
                    onSuccess()
                    Log.e("FIB FireStore" ,"ViewModel : Room Joined Successfully")
                },
                onFailure = {
                    viewModelScope.launch {
                        _joinRoomStateFlow.emit(Resource.Failure(message = it.message))
                    }
                    Log.e("FIB FireStore" , "ViewModel Error : ${it.message}")
                }
            )
        }
    }
}