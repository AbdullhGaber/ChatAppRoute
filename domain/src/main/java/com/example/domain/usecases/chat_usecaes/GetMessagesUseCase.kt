package com.example.domain.usecases.chat_usecaes

import com.example.domain.entities.Message
import com.example.domain.repositories.ChatRepository
import javax.inject.Inject

class GetMessagesUseCase @Inject constructor(
    val chatRepository: ChatRepository
) {
    operator fun invoke(
        roomID: String,
        onSuccess: (List<Message>) -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        chatRepository.getMessages(roomID, onSuccess, onFailure)
    }
}