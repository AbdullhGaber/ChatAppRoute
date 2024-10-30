package com.example.data.repositories.auth

import com.example.domain.repositories.AuthRemoteDataSource
import com.example.domain.repositories.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authRemoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        authRemoteDataSource.login(email, password, onSuccess, onFailure)
    }
}