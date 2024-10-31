package com.example.chatapproute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapproute.screens.register.RegisterScreen
import com.example.chatapproute.screens.register.RegisterScreenState
import com.example.chatapproute.screens.register.RegisterViewModel
import com.example.chatapproute.ui.theme.ChatAppRouteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChatAppRouteTheme {
                val registerViewModel : RegisterViewModel = hiltViewModel()

                val registerScreenState = RegisterScreenState(
                    nameFieldState = registerViewModel.nameFieldState,
                    emailFieldState = registerViewModel.emailFieldState,
                    passwordFieldState = registerViewModel.passwordFieldState,
                    isPasswordVisibleState = registerViewModel.isPasswordVisibleState,
                    nameFieldStateError = registerViewModel.nameFieldStateError,
                    emailFieldStateError = registerViewModel.emailFieldStateError,
                    passwordFieldStateError = registerViewModel.passwordFieldStateError,
                    registerStateFlow = registerViewModel.registerStateFlow.collectAsState()
                )

                RegisterScreen(
                    registerScreenEvents = registerViewModel::onEvent,
                    registerScreenState = registerScreenState
                )
            }
        }
    }
}