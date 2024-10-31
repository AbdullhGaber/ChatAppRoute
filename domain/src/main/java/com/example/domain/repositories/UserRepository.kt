package com.example.domain.repositories

import com.example.domain.entities.AppUser

interface UserRepository {
    fun saveUser(
        user: AppUser,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    )
    fun getUser(
        uid: String,
        onSuccess: (AppUser) -> Unit,
        onFailure: (Throwable) -> Unit,
    )
}

interface UserRemoteDataSource{
   fun saveUser(
       user: AppUser,
       onSuccess: () -> Unit,
       onFailure: (Throwable) -> Unit,
   )

   fun getUser(
        uid: String,
        onSuccess: (AppUser) -> Unit,
        onFailure: (Throwable) -> Unit,
   )
}