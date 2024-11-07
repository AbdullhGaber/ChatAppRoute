package com.example.data.data_source.chat

import android.util.Log
import com.example.domain.entities.ChatRoom
import com.example.domain.repositories.ChatRemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class ChatRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : ChatRemoteDataSource {
    override fun addRoom(room: ChatRoom, onSuccess: () -> Unit, onFailure: (Throwable) -> Unit) {
        val docRef = firestore.collection(ChatRoom.ROOM_COLLECTION).document()
        docRef.apply {
            room.id = this.id
            set(room).addOnSuccessListener {
                onSuccess()
                Log.e("FIB FireStore" , "room added")
            }.addOnFailureListener{
                onFailure(it)
                Log.e("FIB FireStore" , "Error : ${it.message}")
            }
        }

    }
}