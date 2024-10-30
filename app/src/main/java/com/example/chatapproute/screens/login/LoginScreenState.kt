package com.example.chatapproute.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.data.util.Resource

data class LoginScreenState(
    val emailFieldState : MutableState<String> = mutableStateOf(""),
    val passwordFieldState : MutableState<String> = mutableStateOf(""),
    val isPasswordVisibleState : MutableState<Boolean> = mutableStateOf(false),
    val emailFieldStateError : MutableState<String> = mutableStateOf(""),
    val passwordFieldStateError : MutableState<String> = mutableStateOf(""),
    val loginStateFlow : State<Resource<Unit>> = mutableStateOf(Resource.Unspecified())
)
