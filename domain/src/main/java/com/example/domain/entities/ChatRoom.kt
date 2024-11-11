package com.example.domain.entities

import java.io.Serializable

data class ChatRoom(
    var id: String? = null,
    val name : String? = null,
    val uid : String? = null,
    val description : String? = null,
    val categoryId : String? = null,
    val joinedUID : List<String?> = listOf(uid)
) : Serializable{
    companion object{
        const val ROOM_COLLECTION = "rooms"
    }
}
