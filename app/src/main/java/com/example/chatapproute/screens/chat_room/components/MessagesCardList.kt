package com.example.chatapproute.screens.chat_room.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.domain.entities.Message

@Composable
fun MessagesCardList(
    modifier : Modifier = Modifier,
    messages : List<Message>
){
    LazyColumn(
        modifier = modifier
    ){
        items(messages){ message ->
            if(message.senderID == "0"){
                SentMessageCard(message = message)
            }else{
                ReceivedMessageCard(message = message)
            }
        }
    }
}

@Composable
@Preview
fun PreviewMessagesCardList(){
    Box(modifier = Modifier.fillMaxSize()){
        MessagesCardList(
            messages = listOf(
                Message(
                    content = "Hello bro",
                    senderID = "0"
                ),

                Message(
                    content = "Hello friend",
                    senderID = "1"
                ),

                Message(
                    content = "How are you",
                    senderID = "1"
                ),
                Message(
                    content = "Are you alright",
                    senderID = "1"
                ),
                Message(
                    content = "Yes I'm fine",
                    senderID = "0"
                ),
            )
        )
    }
}