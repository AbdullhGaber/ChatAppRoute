package com.example.chatapproute.screens.register

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.data.util.Resource

data class RegisterScreenState(
    val nameFieldState : MutableState<String> = mutableStateOf(""),
    val emailFieldState : MutableState<String> = mutableStateOf(""),
    val passwordFieldState : MutableState<String> = mutableStateOf(""),
    val isPasswordVisibleState : MutableState<Boolean> = mutableStateOf(false),
    val nameFieldStateError : MutableState<String> = mutableStateOf(""),
    val emailFieldStateError : MutableState<String> = mutableStateOf(""),
    val passwordFieldStateError : MutableState<String> = mutableStateOf(""),
    val registerStateFlow : State<Resource<Unit>> = mutableStateOf(Resource.Unspecified())
)
