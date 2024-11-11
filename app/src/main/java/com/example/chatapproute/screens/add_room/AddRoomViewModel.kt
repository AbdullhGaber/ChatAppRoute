package com.example.chatapproute.screens.add_room

import android.util.Log
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.util.Resource
import com.example.domain.entities.ChatRoom
import com.example.domain.usecases.chat_usecaes.ChatUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddRoomViewModel @Inject constructor(
    private val chatUseCases: ChatUseCases
) : ViewModel() {
    private val _addRoomStateFlow = MutableStateFlow<Resource<Unit>>(Resource.Unspecified())
    val addRoomStateFlow = _addRoomStateFlow.asStateFlow()

    val roomNameState = mutableStateOf("")
    val selectedRoomState = mutableIntStateOf(0)
    val roomDescriptionState = mutableStateOf("")
    val isDropMenuExpanded = mutableStateOf(false)
    val roomNameError = mutableStateOf("")
    val roomDescriptionError = mutableStateOf("")

    fun onEvent(event: AddRoomScreenEvents){
        when(event){
            is AddRoomScreenEvents.AddRoom -> {
                addRoom(event.room, event.onSuccess)
            }
        }
    }

    private fun fieldsValid() : Boolean{
        if(roomNameState.value.isEmpty()){
            roomNameError.value = "Required"
        }

        if(roomDescriptionState.value.isEmpty()){
            roomDescriptionError.value = "Required"
        }

        if(roomNameError.value.isNotEmpty() || roomDescriptionError.value.isNotEmpty())
            return false

        return true
    }

    private fun addRoom(
        room : ChatRoom,
        onSuccess : () -> Unit
    ){
        viewModelScope.launch {
            _addRoomStateFlow.emit(Resource.Loading())
            if(fieldsValid()){
                chatUseCases.addRomeUseCase(
                    room = room,
                    onSuccess = {
                        viewModelScope.launch {
                            _addRoomStateFlow.emit(Resource.Success(Unit))
                        }
                        Log.e("FIB FireStore" , "Room added from viewModel")
                        onSuccess()
                    },
                    onFailure = {
                        viewModelScope.launch {
                            _addRoomStateFlow.emit(Resource.Failure(it.message.toString()))
                            Log.e("FIB FireStore" , "ViewModel Error : ${it.message.toString()}")
                        }
                    }
                )
            }
        }
    }
}