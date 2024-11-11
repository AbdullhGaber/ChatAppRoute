package com.example.chatapproute.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapproute.ui.theme.BluePrimaryColor

@Composable
fun PrimaryButton(
    modifier : Modifier = Modifier,
    onClick : () -> Unit,
    text : String
){
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = BluePrimaryColor
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(text = text , color = Color.White, fontSize = 18.sp )
    }
}

@Composable
@Preview
fun PreviewPrimaryButton(){
    PrimaryButton(
        onClick = {},
        text = "create"
    )
}