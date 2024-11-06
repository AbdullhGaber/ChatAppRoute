package com.example.chatapproute.screens.register


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapproute.R
import com.example.chatapproute.components.ChatTextField
import com.example.chatapproute.components.ChatAppButton
import com.example.chatapproute.components.ChatAppTopBar
import com.example.chatapproute.ui.theme.BluePrimaryColor
import com.example.chatapproute.ui.theme.LightGrey

@Composable
fun RegisterScreen(
    registerScreenEvents: (RegisterScreenEvents) -> Unit = {},
    registerScreenState: RegisterScreenState = RegisterScreenState()
){
    Scaffold(
        topBar = {
            ChatAppTopBar(title = "Register")
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
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))
            Text(text = "Full Name" , fontSize = 12.sp, color = LightGrey)
            ChatTextField(
                value = registerScreenState.nameFieldState.value,
                onValueChange = {
                    registerScreenState.nameFieldState.value = it
                    registerScreenState.nameFieldStateError.value = ""
                },
                label = "name",
                error = registerScreenState.nameFieldStateError.value
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Email" , fontSize = 12.sp, color = LightGrey)
            ChatTextField(
                value =  registerScreenState.emailFieldState.value,
                onValueChange = {
                    registerScreenState.emailFieldState.value = it
                    registerScreenState.emailFieldStateError.value = ""
                },
                label = "email",
                error = registerScreenState.emailFieldStateError.value
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Password" , fontSize = 12.sp , color = LightGrey)
            ChatTextField(
                value = registerScreenState.passwordFieldState.value,
                onValueChange = {
                    registerScreenState.passwordFieldState.value = it
                    registerScreenState.passwordFieldStateError.value = ""
                },
                isPasswordField = true,
                isPasswordVisible = registerScreenState.isPasswordVisibleState.value,
                onPasswordVisibilityChange = {
                    registerScreenState.isPasswordVisibleState.value = it
                },
                label = "password",
                error =  registerScreenState.passwordFieldStateError.value
            )
            Spacer(modifier = Modifier.height(32.dp))

            ChatAppButton(
                text = "Register",
                onClick = {
                    val name = registerScreenState.nameFieldState.value
                    val email = registerScreenState.emailFieldState.value
                    val password = registerScreenState.passwordFieldState.value
                    registerScreenEvents(RegisterScreenEvents.Register(name,email,password))
                },
                backgroundColor = BluePrimaryColor
            )
        }
    }
}

@Composable
@Preview
fun PreviewRegisterScreen(){
    RegisterScreen()
}

