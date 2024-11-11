package com.example.chatapproute.model

import androidx.annotation.DrawableRes
import com.example.chatapproute.R

data class Category(
    val categoryID : String,
    val name : String,
    @DrawableRes val image : Int,
){
    companion object{
        const val MUSIC_CATEGORY = "music"
        const val SPORTS_CATEGORY = "sports"
        const val MOVIES_CATEGORY = "movies"

        fun getCategories() : List<Category>{
            return listOf(
                Category(MUSIC_CATEGORY , "music" , R.drawable.music),
                Category(SPORTS_CATEGORY , "sports" , R.drawable.sports),
                Category(MOVIES_CATEGORY , "movies" , R.drawable.movies),
            )
        }
    }
}
