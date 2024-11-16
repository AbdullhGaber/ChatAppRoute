package com.example.data.data_source.chat

import android.util.Log
import com.example.domain.entities.ChatRoom
import com.example.domain.entities.Message
import com.example.domain.entities.Message.Companion.MESSAGE_COLLECTION
import com.example.domain.repositories.ChatRemoteDataSource
import com.google.firebase.firestore.FieldValue
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

    override fun getRooms(onSuccess: (List<ChatRoom>) -> Unit, onFailure: (Throwable) -> Unit) {
        val collecRef = firestore.collection(ChatRoom.ROOM_COLLECTION)

        collecRef.addSnapshotListener { value, error ->
            if(error != null){
                onFailure(error)
                Log.e("FIB FireStore" , error.toString())
                return@addSnapshotListener
            }

            val rooms = value?.toObjects(ChatRoom::class.java)
            Log.e("FIB FireStore" , "Success from data source : $rooms")
            onSuccess(rooms!!)
        }
    }

    override fun joinRoom(
        roomID: String,
        uid: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        val chatRef = firestore.collection(ChatRoom.ROOM_COLLECTION).document(roomID)

        chatRef.update("joinedUID",FieldValue.arrayUnion(uid))
            .addOnSuccessListener {
                Log.e("FIB FireStore" , "Added uid successfully")
                onSuccess()
            }.addOnFailureListener {
                Log.e("FIB FireStore" , "Error : $it")
                onFailure(it)
            }
    }

    override fun sendMessage(
        message: Message,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ){
        firestore.collection(ChatRoom.ROOM_COLLECTION)
            .document(message.roomID!!)
            .collection(MESSAGE_COLLECTION)
            .document()
            .set(message)
            .addOnSuccessListener {
                onSuccess()
                Log.e("FIB FireStore" , "Message Sent")
            }.addOnFailureListener {
                onFailure(it)
                Log.e("FIB FireStore","Error : ${it.message}")
            }
    }
}