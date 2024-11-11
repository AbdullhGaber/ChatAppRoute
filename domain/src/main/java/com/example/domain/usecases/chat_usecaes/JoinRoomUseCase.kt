package com.example.domain.usecases.chat_usecaes

import com.example.domain.entities.ChatRoom
import com.example.domain.repositories.ChatRepository
import javax.inject.Inject

class JoinRoomUseCase @Inject constructor(
    private val chatRepository : ChatRepository
) {

    operator fun invoke(
        roomID : String,
        uid : String,
        onSuccess : () -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        chatRepository.joinRoom(roomID, uid, onSuccess, onFailure)
    }
}