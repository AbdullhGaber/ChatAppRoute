package com.example.domain.repositories

interface AuthRepository {
    fun login(
        email: String,
        password: String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )

    fun register(
        email: String,
        password: String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )
}

interface AuthRemoteDataSource{
    fun login(
        email: String,
        password: String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )

    fun register(
        email: String,
        password: String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    )
}