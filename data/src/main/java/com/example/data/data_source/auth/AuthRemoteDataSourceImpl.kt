package com.example.data.data_source.auth

import com.example.domain.repositories.AuthRemoteDataSource
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val firebaseAuth : FirebaseAuth
) : AuthRemoteDataSource {
    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        firebaseAuth.signInWithEmailAndPassword(email , password)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener {
                onFailure(it)
            }
    }

    override fun register(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email , password)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener {
                onFailure(it)
            }
    }
}