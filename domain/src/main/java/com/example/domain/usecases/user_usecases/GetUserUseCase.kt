package com.example.domain.usecases.user_usecases

import com.example.domain.entities.AppUser
import com.example.domain.repositories.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(
        uid : String,
        onSuccess : (AppUser) -> Unit,
        onFailure : (Throwable) -> Unit
    ) {
        userRepository.getUser(uid, onSuccess, onFailure)
    }
}