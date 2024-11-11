package com.example.domain.usecases.auth_usecases

import com.example.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
){
    operator fun invoke(
        email: String,
        password: String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        authRepository.login(email, password , onSuccess , onFailure)
    }
}