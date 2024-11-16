package com.example.domain.usecases.chat_usecaes

data class ChatUseCases(
    val addRomeUseCase : AddRomeUseCase,
    val getRoomsUseCase: GetRoomsUseCase,
    val joinRoomUseCase : JoinRoomUseCase,
    val sendMessageUseCase: SendMessageUseCase
)
