package com.example.domain.entities

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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

    fun formatDate() : String {
        val date = Date(dateTime!!)
        val dateFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())

        return dateFormat.format(date)
    }
}
