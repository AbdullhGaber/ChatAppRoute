package com.example.chatapproute.screens.nav_graph

sealed class Route(val route : String) {
    data object AuthNavigation : Route("authNavigation")
    data object SignUpScreen : Route("signupScreen")
    data object LoginScreen : Route("loginScreen")

    data object HomeNavigation : Route("homeNavigation")
    data object HomeScreen : Route("homeScreen")
    data object AddRoomScreen : Route("addRoomScreen")
    data object JoinRoomScreen : Route("joinRoomScreen")
    data object ChatRoomScreen : Route("chatRoomScreen")
}