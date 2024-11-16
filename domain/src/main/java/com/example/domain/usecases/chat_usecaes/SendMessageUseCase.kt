package com.example.domain.usecases.chat_usecaes

import com.example.domain.entities.Message
import com.example.domain.repositories.ChatRepository
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val chatRepository: ChatRepository
){
    operator fun invoke(
        message: Message,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ){
        chatRepository.sendMessage(message, onSuccess, onFailure)
    }
}