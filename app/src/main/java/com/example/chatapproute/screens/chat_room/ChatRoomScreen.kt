package com.example.chatapproute.screens.chat_room

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapproute.R
import com.example.chatapproute.components.ChatAppTopBar
import com.example.chatapproute.screens.chat_room.components.MessagesCardList
import com.example.chatapproute.ui.theme.BluePrimaryColor
import com.example.data.util.DataUtils
import com.example.domain.entities.ChatRoom
import com.example.domain.entities.Message
import java.util.Date

@Composable
fun ChatRoomScreen(
    room : ChatRoom = ChatRoom(),
    screenEvents: (ChatRoomScreenEvents) -> Unit = {},
    screenStates: ChatRoomScreenStates = ChatRoomScreenStates()
){
    Scaffold(
        topBar = {
            ChatAppTopBar(
                title = room.name!!,
                hasNavIcon = true,
                navIcon = R.drawable.ic_arrow_back
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = R.drawable.bg),
                    contentScale = ContentScale.Crop
                )
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
        ){
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))

            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        TextField(
                            modifier = Modifier
                                .border(
                                    1.dp,
                                    Color.Gray,
                                    RoundedCornerShape(bottomEnd = 20.dp)
                                )
                                .weight(2f),
                            value = screenStates.messageState.value,
                            onValueChange = {
                                screenStates.messageState.value = it
                            },
                            placeholder = {
                                Text(text = "Type a message")
                            },
                            shape = RoundedCornerShape(bottomEnd = 20.dp),
                            enabled = true,
                            colors = TextFieldDefaults.colors(
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                            )
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Button(
                            enabled = screenStates.messageState.value.isNotEmpty(),
                            modifier = Modifier.weight(1f),
                            onClick = {
                                val message = Message(
                                    senderID = DataUtils.uid,
                                    senderName = DataUtils.appUser?.name,
                                    roomID = room.id,
                                    dateTime = Date().time,
                                    content = screenStates.messageState.value
                                )
                                screenEvents(ChatRoomScreenEvents.SendMessage(message))
                            },
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = BluePrimaryColor,
                                contentColor = Color.White
                            ),
                        ){
                            Text(text = "Send")

                            Spacer(modifier = Modifier.width(4.dp))

                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.Send,
                                contentDescription = stringResource(
                                    R.string.send_icon
                                ),
                                tint = Color.White
                            )
                        }
                    }

                    MessagesCardList(messages = listOf())
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewChatRoom(){
    ChatRoomScreen(
        room = ChatRoom(
            name = "ANDROID ROOM",

        )
    )
}