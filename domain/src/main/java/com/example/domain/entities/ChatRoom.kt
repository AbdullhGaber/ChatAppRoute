package com.example.domain.entities

data class ChatRoom(
    var id: String? = null,
    val name : String? = null,
    val uid : String? = null,
    val description : String? = null,
    val categoryId : String? = null
){
    companion object{
        const val ROOM_COLLECTION = "rooms"
    }
}
