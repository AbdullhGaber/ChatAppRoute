package com.example.chatapproute.screens.add_room

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapproute.R
import com.example.chatapproute.components.ChatAppTopBar
import com.example.chatapproute.components.ChatTextField
import com.example.chatapproute.model.Category
import com.example.chatapproute.components.PrimaryButton
import com.example.data.util.DataUtils
import com.example.domain.entities.ChatRoom


@Composable
fun AddRoomScreen(
    addRoomScreenEvents: (AddRoomScreenEvents) -> Unit = {},
    addRoomScreenStates: AddRoomScreenStates = AddRoomScreenStates(),
    navigateUp : () -> Unit = {}
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
            Card(
                modifier = Modifier.padding(horizontal = 8.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(20.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ){
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(text = stringResource(R.string.create_room) , fontSize = 24.sp)

                    Spacer(modifier = Modifier.height(8.dp))

                    Image(
                        modifier = Modifier.size(200.dp),
                        painter = painterResource(id = R.drawable.users_room),
                        contentDescription = stringResource(
                            R.string.users_icon
                        ),
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    ChatTextField(
                        value = addRoomScreenStates.roomNameState.value,
                        onValueChange = {
                            addRoomScreenStates.roomNameState.value = it
                            addRoomScreenStates.roomNameError.value = ""
                        },
                        label = stringResource(R.string.enter_room_name) ,
                        error = addRoomScreenStates.roomNameError.value
                    )

                    Spacer(modifier = Modifier.height(32.dp))
                    val selectedCategory = Category.getCategories()[addRoomScreenStates.selectedRoomState.value]

                    CategoryMenuItem(addRoomScreenStates, selectedCategory)

                    Spacer(modifier = Modifier.height(16.dp))

                    ChatTextField(
                        value = addRoomScreenStates.roomDescription.value,
                        onValueChange = {
                            addRoomScreenStates.roomDescription.value = it
                            addRoomScreenStates.roomDescriptionError.value = ""
                        },
                        label = stringResource(R.string.enter_room_description) ,
                        error = addRoomScreenStates.roomDescriptionError.value
                    )

                    Spacer(modifier = Modifier.height(32.dp))

                    PrimaryButton(
                        onClick = {
                            val roomName = addRoomScreenStates.roomNameState.value
                            val roomDesc = addRoomScreenStates.roomDescription.value
                            val uid = DataUtils.uid?: "NO USER ID"
                            val room = ChatRoom(
                                name = roomName,
                                description = roomDesc,
                                uid = uid,
                                categoryId = selectedCategory.categoryID,
                            )
                            addRoomScreenEvents(AddRoomScreenEvents.AddRoom(room , navigateUp))
                        },
                        text = "Create",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun CategoryMenuItem(
    roomScreenStates: AddRoomScreenStates,
    selectedCategory: Category,
) {
    ExposedDropdownMenuBox(
        modifier = Modifier,
        expanded = roomScreenStates.isDropMenuExpanded.value,
        onExpandedChange = {
            roomScreenStates.isDropMenuExpanded.value = !roomScreenStates.isDropMenuExpanded.value
        }
    ) {
        TextField(
            value = selectedCategory.name,
            onValueChange = {},
            readOnly = true,
            modifier = Modifier
                .menuAnchor()
                .border(1.dp, Color.Gray, RectangleShape),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = roomScreenStates.isDropMenuExpanded.value)
            },
            leadingIcon = {
                Image(
                    painter = painterResource(
                        id = selectedCategory.image
                    ),
                    modifier = Modifier.size(36.dp),
                    contentScale = Crop,
                    contentDescription = stringResource(R.string.category_selection_icon)
                )
            }
        )

        ExposedDropdownMenu(
            expanded = roomScreenStates.isDropMenuExpanded.value,
            onDismissRequest = {
                roomScreenStates.isDropMenuExpanded.value = false
            },
        ) {
            Category.getCategories().forEachIndexed { index, category ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(
                                    id = category.image
                                ),
                                contentDescription = stringResource(R.string.category_image_selection),
                                modifier = Modifier.size(36.dp), contentScale = Crop
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(text = category.name, fontSize = 18.sp)
                        }
                    },
                    onClick = {
                        roomScreenStates.selectedRoomState.value = index
                        roomScreenStates.isDropMenuExpanded.value = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}

@Composable
@Preview
fun PreviewAddRoomScreen(){
    AddRoomScreen()
}