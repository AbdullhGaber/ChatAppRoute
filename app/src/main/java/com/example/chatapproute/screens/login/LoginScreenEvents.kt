package com.example.chatapproute.screens.login

sealed class LoginScreenEvents {
    data class Login(val email: String, val password : String) : LoginScreenEvents()
}