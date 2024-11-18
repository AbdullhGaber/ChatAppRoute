package com.example.chatapproute.screens.chat_room.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapproute.ui.theme.GraySecondaryColor
import com.example.domain.entities.Message

@Composable
fun ReceivedMessageCard(
    modifier : Modifier = Modifier,
    message : Message = Message()
){
    Column {
        Text(
            modifier = Modifier.padding(top = 10.dp , start = 10.dp),
            text = message.senderName ?: "NO NAME",
            color = Color.Gray
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Card(
                shape = RoundedCornerShape(
                    bottomStart = 0.dp,
                    bottomEnd = 20.dp,
                    topStart = 20.dp,
                    topEnd = 20.dp
                ),
                colors = CardDefaults.cardColors(containerColor = GraySecondaryColor),
                modifier = modifier.padding(10.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ){
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = message.content ?: ""
                )
            }

            Text(
                modifier = Modifier.padding(top = 10.dp),
                text = message.formatDate()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewReceivedMessageCard(){
    ReceivedMessageCard(
        message = Message(senderName = "Ferry" ,content = "Hello My Dear" , dateTime = 1731867941549)
    )
}