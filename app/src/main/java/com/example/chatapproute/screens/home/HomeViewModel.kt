package com.example.chatapproute.screens.home

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.mutableIntStateOf
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
class HomeViewModel @Inject constructor(
    private val chatUseCases : ChatUseCases
) : ViewModel() {
    private val _roomsStateFlow = MutableStateFlow<Resource<List<ChatRoom>>>(Resource.Unspecified())
    val roomsStateFlow = _roomsStateFlow.asStateFlow()

    val tabRowSelectedIndex = mutableIntStateOf(0)

    fun onEvent(event : HomeScreenEvents){
        when(event){
            is HomeScreenEvents.GetRooms -> {
                getRooms()
            }
        }
    }

    private fun getRooms(){
        viewModelScope.launch {
            _roomsStateFlow.emit(Resource.Loading())

            chatUseCases.getRoomsUseCase(
                onSuccess = {
                    viewModelScope.launch{
                        _roomsStateFlow.emit(Resource.Success(data = it))
                    }
                    Log.e("FIB FireStore","Rooms retrieved successfully : ViewModel")
                },
                onFailure = {
                    viewModelScope.launch{
                        _roomsStateFlow.emit(Resource.Failure(message = it.message))
                    }
                    Log.e("FIB FireStore","ViewModel Error : ${it.message}")
                }
            )
        }
    }


}