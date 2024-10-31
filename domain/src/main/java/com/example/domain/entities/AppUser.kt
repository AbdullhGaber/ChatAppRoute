package com.example.domain.entities

data class AppUser(
    val uid : String? = null,
    val name : String? = null,
    val email : String? = null,
){
    companion object{
        const val USER_COLLECTION = "users"
    }
}
