package com.example.data.util

import com.example.domain.entities.AppUser
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

object DataUtils{
    val uid = Firebase.auth.currentUser?.uid ?: "o8xX48d5TqN4Ucq3PKOlTmkdhdj1"

//    val appUser = FirebaseFirestore.getInstance().collection(AppUser.USER_COLLECTION).document(
//        firebaseUser?.uid ?: "").get().result.toObject(AppUser::class.java)
}