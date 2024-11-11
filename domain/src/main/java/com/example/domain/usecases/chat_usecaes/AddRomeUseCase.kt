package com.example.domain.usecases.chat_usecaes

import com.example.domain.entities.ChatRoom
import com.example.domain.repositories.ChatRepository
import javax.inject.Inject

class AddRomeUseCase @Inject constructor(
    private val chatRepository : ChatRepository
){
    operator fun invoke(
        room : ChatRoom,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        chatRepository.addRoom(room, onSuccess, onFailure)
    }
}