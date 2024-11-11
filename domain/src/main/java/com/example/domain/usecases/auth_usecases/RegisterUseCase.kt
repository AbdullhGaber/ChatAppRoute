package com.example.domain.usecases.auth_usecases

import com.example.domain.repositories.AuthRepository

class RegisterUseCase(
    private val authRepository: AuthRepository
) {
    operator fun invoke(
        email: String,
        password: String,
        onSuccess : (String) -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        authRepository.register(email, password , onSuccess , onFailure)
    }
}