package com.example.chatapproute.screens.register

sealed class RegisterScreenEvents {
    data class Register(val name :String , val email : String , val password : String) : RegisterScreenEvents()
}