package com.example.chatapproute.screens.join_room

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapproute.R
import com.example.chatapproute.components.ChatAppTopBar
import com.example.chatapproute.components.PrimaryButton
import com.example.chatapproute.model.Category
import com.example.chatapproute.screens.nav_graph.Route
import com.example.data.util.DataUtils
import com.example.data.util.Resource
import com.example.domain.entities.ChatRoom
import java.io.Serializable

@Composable
fun JoinRoomScreen(
    room : ChatRoom = ChatRoom(),
    joinRoomScreenEvents: (JoinRoomScreenEvents) -> Unit = {},
    joinRoomScreenStates: JoinRoomStates = JoinRoomStates(),
    navigateToScreen : (String,String,Serializable) -> Unit = {s1,s2,s3 ->}
){
    Scaffold(
        topBar = {
            ChatAppTopBar(title = stringResource(R.string.chat_app))
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .paint(
                    painter = painterResource(id = R.drawable.bg),
                    contentScale = Crop
                )
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),

            ){
            Spacer(modifier = Modifier.fillMaxHeight(0.1f))
            if(joinRoomScreenStates.joinRoomStateFlow.value is Resource.Loading){
                CircularProgressIndicator()
            }else{
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
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Text(
                            text = stringResource(R.string.hello_welcome_to_our_chat_room),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Thin
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Join ${room.name}",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        val category = Category.getCategories().single{ it.categoryID == room.categoryId}

                        Image(
                            modifier = Modifier.size(200.dp),
                            painter = painterResource(id = category.image),
                            contentDescription = stringResource(
                                R.string.category_image
                            ),
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = room.description ?: "NO DESCRIPTION",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Thin
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        PrimaryButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Join",
                            onClick = {
                                joinRoomScreenEvents(JoinRoomScreenEvents.JoinRoom(
                                    roomID = room.id!!,
                                    uid = DataUtils.uid,
                                    onSuccess = {
                                        navigateToScreen(Route.ChatRoomScreen.route,"room", room)
                                    }
                                ))
                            }
                        )
                    }
                }
            }

        }
    }
}

@Composable
@Preview
fun PreviewJoinRoomScreen(){
    JoinRoomScreen(
        ChatRoom(
            name = "Room Name",
            categoryId = Category.MOVIES_CATEGORY,
            description = "JUST SOME RANDOM DESC"
        )
    )
}