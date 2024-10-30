package com.example.chatapproute.util

import androidx.compose.runtime.MutableState

fun areAuthFieldsValid(
    name: String,
    nameFieldStateError : MutableState<String>,
    email: String,
    emailFieldStateError : MutableState<String>,
    password: String,
    passwordFieldStateError : MutableState<String>,
) : Boolean{

    if(name.isEmpty()){
        nameFieldStateError.value = "Name field is required"
        return false
    }

    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    if(email.isEmpty()){
        emailFieldStateError.value = "Email field is required"
        return false
    }

    if(!emailRegex.matches(email)){
        emailFieldStateError.value = "Email format is not correct"
        return false
    }

    if(password.isEmpty()){
        passwordFieldStateError.value = "Password is required"
        return false
    }

    if(password.length < 6){
        passwordFieldStateError.value = "Password shouldn't be less than 6 chars"
        return false
    }

    return true
}

fun areAuthFieldsValid(
    email: String,
    emailFieldStateError : MutableState<String>,
    password: String,
    passwordFieldStateError : MutableState<String>,
) : Boolean{

    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
    if(email.isEmpty()){
        emailFieldStateError.value = "Email field is required"
        return false
    }

    if(!emailRegex.matches(email)){
        emailFieldStateError.value = "Email format is not correct"
        return false
    }

    if(password.isEmpty()){
        passwordFieldStateError.value = "Password is required"
        return false
    }

    if(password.length < 6){
        passwordFieldStateError.value = "Password shouldn't be less than 6 chars"
        return false
    }

    return true
}