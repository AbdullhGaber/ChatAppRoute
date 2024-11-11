package com.example.chatapproute

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chatapproute.screens.nav_graph.NavGraph
import com.example.chatapproute.screens.nav_graph.Route
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
               NavGraph(startDestination = Route.HomeNavigation.route)
            }
        }
    }
}