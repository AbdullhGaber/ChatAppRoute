package com.example.domain.usecases.user_usecases

import com.example.domain.entities.AppUser
import com.example.domain.repositories.UserRepository
import javax.inject.Inject

class SaveUserUseCase @Inject constructor(
    val userRepository: UserRepository
){
    operator fun invoke(
        user: AppUser,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        userRepository.saveUser(user, onSuccess, onFailure)
    }
}