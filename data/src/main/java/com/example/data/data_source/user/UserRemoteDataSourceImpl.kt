package com.example.data.data_source.user

import android.util.Log
import com.example.domain.entities.AppUser
import com.example.domain.entities.AppUser.Companion.USER_COLLECTION
import com.example.domain.repositories.UserRemoteDataSource
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class UserRemoteDataSourceImpl @Inject constructor(
    private val fireStore : FirebaseFirestore
) : UserRemoteDataSource {
    override fun saveUser(
        user: AppUser,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        fireStore.collection(USER_COLLECTION).document(user.uid!!).set(user)
            .addOnSuccessListener {
                onSuccess()
                Log.e("FIB FireStore" , "User saved Successfully")
            }.addOnFailureListener {
                onFailure(it)
            }
    }

    override fun getUser(
        uid: String,
        onSuccess: (AppUser) -> Unit,
        onFailure: (Throwable) -> Unit,
    ){
        val userSnap = fireStore.collection(USER_COLLECTION).document(uid).get()
         userSnap.addOnSuccessListener{
            val user = it.toObject(AppUser::class.java)
             if(user != null){
                 onSuccess(user)
                 Log.e("FIB FireStore" , "User retrieved successfully : $user")
             }else{
                 onFailure(Exception("User == null"))
                 Log.e("FIB FireStore" , "User is null")
             }
        }.addOnFailureListener{
             onFailure(it)
             Log.e("FIB FireStore" , it.message.toString())
        }
    }
}