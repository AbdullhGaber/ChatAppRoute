package com.example.chatapproute.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapproute.R
import com.example.chatapproute.model.Category
import com.example.domain.entities.ChatRoom

@Composable
fun RoomCard(
    modifier : Modifier = Modifier,
    onClick : (ChatRoom) -> Unit = {},
    room: ChatRoom = ChatRoom()
){
    Card(
        modifier = modifier,
        onClick = {
            onClick(room)
        },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            val roomCategory = Category.getCategories().single{ it.categoryID == room.categoryId }

            Image(
                painter = painterResource(id = roomCategory.image),
                contentDescription = stringResource(R.string.category_image)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = room.name ?: "No Name" , fontSize = 14.sp )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "${room.joinedUID.size} Members" , fontSize = 8.sp )
        }
    }
}

@Composable
@Preview
fun PreviewRoomCard(){
    RoomCard(room = ChatRoom(name = "The Movies Zone" , categoryId = Category.MOVIES_CATEGORY , joinedUID = listOf("")))
}