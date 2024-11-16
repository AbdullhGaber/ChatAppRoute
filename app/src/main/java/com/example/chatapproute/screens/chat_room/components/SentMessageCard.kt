package com.example.chatapproute.screens.chat_room.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapproute.ui.theme.BluePrimaryColor
import com.example.domain.entities.Message

@Composable
fun SentMessageCard(
    modifier : Modifier = Modifier,
    message: Message = Message()
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ){
        Card(
            shape = RoundedCornerShape(
                bottomStart = 20.dp,
                bottomEnd = 0.dp,
                topStart = 20.dp,
                topEnd = 20.dp
            ),
            colors = CardDefaults.cardColors(containerColor = BluePrimaryColor),
            modifier = modifier.padding(10.dp),
            elevation = CardDefaults.cardElevation(10.dp)
        ){
            Text(
                modifier = Modifier.padding(8.dp),
                text = message.content ?: "",
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun PreviewSentMessageCard(){
    SentMessageCard(
        message = Message(content = "Hello")
    )
}