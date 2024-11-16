package com.example.data.util

import com.example.domain.entities.AppUser
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth


object DataUtils{
    val uid = Firebase.auth.currentUser?.uid ?: "o8xX48d5TqN4Ucq3PKOlTmkdhdj1"
    var appUser : AppUser? = null
    var firebUser : FirebaseUser? = null

}