package com.example.domain.usecases.chat_usecaes

import com.example.domain.entities.ChatRoom
import com.example.domain.repositories.ChatRepository
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {
    operator fun invoke(
        onSuccess : (List<ChatRoom>) -> Unit,
        onFailure : (Throwable) -> Unit
    ){
        chatRepository.getRooms(onSuccess, onFailure)
    }
}