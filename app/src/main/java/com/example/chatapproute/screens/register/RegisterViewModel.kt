package com.example.chatapproute.screens.register

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapproute.util.areAuthFieldsValid
import com.example.data.util.Resource
import com.example.domain.entities.AppUser
import com.example.domain.usecases.auth_usecases.AuthUseCases
import com.example.domain.usecases.user_usecases.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
) : ViewModel(){
    private val _registerStateFlow = MutableStateFlow<Resource<Unit>>(Resource.Unspecified())
    val registerStateFlow = _registerStateFlow.asStateFlow()

    val nameFieldState = mutableStateOf("")
    val emailFieldState = mutableStateOf("")
    val passwordFieldState = mutableStateOf("")
    val isPasswordVisibleState = mutableStateOf(false)

    val nameFieldStateError = mutableStateOf("")
    val emailFieldStateError = mutableStateOf("")
    val passwordFieldStateError = mutableStateOf("")

    fun onEvent(event : RegisterScreenEvents){
        when(event){
            is RegisterScreenEvents.Register -> {
                register(event.email, event.password)
            }
        }
    }

    private fun register(
        email: String,
        password: String
    ){
        viewModelScope.launch {
            _registerStateFlow.emit(
                Resource.Loading()
            )

            val fieldsAreValid = areAuthFieldsValid(
                name = nameFieldState.value,
                email = emailFieldState.value,
                password = passwordFieldState.value,
                nameFieldStateError = nameFieldStateError,
                emailFieldStateError = emailFieldStateError,
                passwordFieldStateError = passwordFieldStateError
            )

            if(fieldsAreValid){
                authUseCases.registerUseCase(
                    email = email,
                    password = password,
                    onSuccess = {
                        viewModelScope.launch {
                            _registerStateFlow.emit(
                                Resource.Success(data = Unit)
                            )
                            Log.e("FIB Auth" , "registered successfully")
                            val user = AppUser(
                                uid = it,
                                name = nameFieldState.value,
                                email = emailFieldState.value
                            )
                            saveUser(user)
                        }
                    },
                    onFailure = {
                        viewModelScope.launch {
                            _registerStateFlow.emit(
                                Resource.Failure(message = it.message)
                            )
                            Log.e("FIB Auth" , "register failed : ${it.message}")
                        }
                    }
                )
            }
        }
    }

    private fun saveUser(user : AppUser){
        userUseCases.saveUserUseCase(
            user = user,
            onSuccess = {
                Log.e("FIB FireStore ViewModel" , "User Saved to firestore from view model")
            },
            onFailure = {
                Log.e("FIB FireStore ViewModel" , it.message.toString())
            }
        )
    }
}