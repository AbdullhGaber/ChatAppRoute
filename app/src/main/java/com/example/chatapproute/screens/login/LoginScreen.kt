package com.example.chatapproute.screens.login

import androidx.compose.foundation.clickable
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
import com.example.chatapproute.components.AuthTextField
import com.example.chatapproute.components.ChatAppButton
import com.example.chatapproute.components.ChatAppTopBar
import com.example.chatapproute.ui.theme.LightGrey
import com.example.data.util.Resource

@Composable
fun LoginScreen(
    loginScreenEvents: (LoginScreenEvents) -> Unit = {},
    loginScreenState: LoginScreenState = LoginScreenState()
){
    val loginState = loginScreenState.loginStateFlow.value

    Scaffold(
        topBar = {
            ChatAppTopBar(title = "Login")
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
            Spacer(modifier = Modifier.fillMaxHeight(0.3f))

            Text(text = "Welcome Back!" , fontSize = 36.sp)

            Spacer(modifier = Modifier.height(32.dp))
            
            Text(text = "Email" , fontSize = 12.sp, color = LightGrey)
            AuthTextField(
                value = loginScreenState.emailFieldState.value,
                onValueChange = {
                    loginScreenState.emailFieldState.value = it
                    loginScreenState.emailFieldStateError.value = ""
                },
                label = "email",
                error = loginScreenState.emailFieldStateError.value
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Password" , fontSize = 12.sp , color = LightGrey)
            AuthTextField(
                value = loginScreenState.passwordFieldState.value,
                onValueChange = {
                    loginScreenState.passwordFieldState.value = it
                    loginScreenState.passwordFieldStateError.value = ""
                },
                isPasswordField = true,
                isPasswordVisible = loginScreenState.isPasswordVisibleState.value,
                onPasswordVisibilityChange = {
                    loginScreenState.isPasswordVisibleState.value = it
                },
                label = "password",
                error = loginScreenState.passwordFieldStateError.value
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Forgot Password ?",
                fontSize = 14.sp,
                modifier = Modifier.clickable {

                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            ChatAppButton(
                text = "Login",
                onClick = {
                    val email = loginScreenState.emailFieldState.value
                    val password = loginScreenState.passwordFieldState.value
                    loginScreenEvents(LoginScreenEvents.Login(email,password))
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Or Create My Account",
                fontSize = 14.sp,
                modifier = Modifier.clickable {

                }
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewLoginScreen(){
    LoginScreen()
}