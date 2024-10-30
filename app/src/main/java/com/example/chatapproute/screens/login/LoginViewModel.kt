package com.example.chatapproute.screens.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.util.Resource
import com.example.domain.usecases.auth_usecases.AuthUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
) : ViewModel() {
    private val _loginStateFlow = MutableStateFlow<Resource<Unit>>(Resource.Unspecified())
    val loginStateFlow = _loginStateFlow.asStateFlow()

    val emailFieldState = mutableStateOf("")
    val passwordFieldState = mutableStateOf("")
    val isPasswordVisibleState = mutableStateOf(false)

    val emailFieldStateError = mutableStateOf("")
    val passwordFieldStateError = mutableStateOf("")

    fun onEvent(event : LoginScreenEvents){
        when(event){
            is LoginScreenEvents.Login -> {
                login(event.email,event.password)
            }
        }
    }

    private fun areLoginFieldsValid(
        email: String,
        password: String
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

    private fun login(
        email:String,
        password:String
    ){
        viewModelScope.launch {
            _loginStateFlow.emit(
                Resource.Loading()
            )
            if(areLoginFieldsValid(email, password)){
                authUseCases.loginUseCase(
                    email = email,
                    password = password,
                    onSuccess = {
                        viewModelScope.launch {
                            _loginStateFlow.emit(
                                Resource.Success(data = Unit)
                            )
                            Log.e("FIB Auth" , "login successfully")
                        }
                    },
                    onFailure = {
                        viewModelScope.launch {
                            _loginStateFlow.emit(
                                Resource.Failure(message = it.message)
                            )
                            Log.e("FIB Auth" , "login failed : ${it.message}")
                        }
                    }
                )
            }
        }
    }
}