package com.example.data.data_source.auth

import com.example.data.util.DataUtils
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
                DataUtils.firebUser = it.user
                onSuccess()
            }.addOnFailureListener {
                onFailure(it)
            }
    }

    override fun register(
        email: String,
        password: String,
        onSuccess: (String) -> Unit,
        onFailure: (Throwable) -> Unit,
    ) {
        firebaseAuth.createUserWithEmailAndPassword(email , password)
            .addOnSuccessListener {
                DataUtils.firebUser = it.user
                onSuccess(it.user?.uid!!)
            }.addOnFailureListener {
                onFailure(it)
            }
    }
}