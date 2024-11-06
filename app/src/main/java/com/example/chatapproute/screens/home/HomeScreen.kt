package com.example.chatapproute.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.chatapproute.R
import com.example.chatapproute.components.ChatAppTopBar
import com.example.chatapproute.ui.theme.BluePrimaryColor

@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            ChatAppTopBar(title = "Home")
        },
        floatingActionButton = {
            IconButton(
                onClick = {

                },
                colors = IconButtonDefaults.iconButtonColors(
                    containerColor = BluePrimaryColor
                ),
                modifier = Modifier.size(60.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add button",
                    tint = Color.White,
                    modifier = Modifier.size(40.dp)
                )
            }
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
                .padding(horizontal = 16.dp)
        ){

        }
    }
}

@Composable
@Preview
fun PreviewHomeScreen(){
    HomeScreen()
}