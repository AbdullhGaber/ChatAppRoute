package com.example.chatapproute.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapproute.model.Category
import com.example.domain.entities.ChatRoom

@Composable
fun RoomCardList(
    modifier : Modifier = Modifier,
    rooms : List<ChatRoom> = emptyList()
){
    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp
    ){
        items(rooms){
            RoomCard(room = it , modifier = modifier.padding(8.dp))
        }
    }
}

@Composable
@Preview
fun PreviewRoomCardList(){
    val rooms = listOf(
        ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
        ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
        ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
        ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
        ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
        ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")),
    )
    RoomCardList(rooms = rooms)
}