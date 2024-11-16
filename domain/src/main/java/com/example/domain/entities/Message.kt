package com.example.domain.entities

data class Message(
    val content : String? = null,
    val roomID : String? = null,
    val senderID : String? = null,
    val senderName : String? = null,
    val dateTime: Long? = null
){
    companion object {
        const val MESSAGE_COLLECTION = "messages"
    }
}
