package com.example.data.repositories.user

import com.example.domain.entities.AppUser
import com.example.domain.repositories.UserRemoteDataSource
import com.example.domain.repositories.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {
    override fun saveUser(
        user: AppUser,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        userRemoteDataSource.saveUser(user, onSuccess, onFailure)
    }

    override fun getUser(
        uid: String,
        onSuccess: (AppUser) -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        userRemoteDataSource.getUser(uid, onSuccess, onFailure)
    }
}