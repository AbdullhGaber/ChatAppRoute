package com.example.chatapproute.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.chatapproute.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatAppTopBar(
    title : String,
    @DrawableRes navIcon : Int = 0,
    hasNavIcon : Boolean = false,
){
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),
        title = {
            Text(text = title , color = Color.White)
        },
        navigationIcon = {
            if(hasNavIcon){
                Icon(
                    painter = painterResource(id = navIcon),
                    contentDescription = stringResource(
                        R.string.nav_icon
                    ),
                    tint = Color.White
                )
            }
        },
    )
}

@Composable
@Preview(showBackground = false)
fun PreviewChatAppTopBar(){
    ChatAppTopBar(title = "Login", navIcon = R.drawable.ic_arrow_back,true)
}