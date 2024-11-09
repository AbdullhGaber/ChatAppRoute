package com.example.chatapproute.screens.nav_graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.chatapproute.screens.add_room.AddRoomScreen
import com.example.chatapproute.screens.add_room.AddRoomScreenStates
import com.example.chatapproute.screens.add_room.AddRoomViewModel
import com.example.chatapproute.screens.home.HomeScreen
import com.example.chatapproute.screens.home.HomeScreenStates
import com.example.chatapproute.screens.home.HomeViewModel
import com.example.chatapproute.screens.login.LoginScreen
import com.example.chatapproute.screens.login.LoginScreenState
import com.example.chatapproute.screens.login.LoginViewModel
import com.example.chatapproute.screens.register.RegisterScreen
import com.example.chatapproute.screens.register.RegisterScreenState
import com.example.chatapproute.screens.register.RegisterViewModel

@Composable
fun NavGraph(
    startDestination : String
){
    val navController = rememberNavController()

    NavHost(navController = navController , startDestination = startDestination){
        navigation(
            route = Route.AuthNavigation.route,
            startDestination = Route.LoginScreen.route
        ){
            composable(
                route = Route.SignUpScreen.route
            ){
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

            composable(
                route = Route.LoginScreen.route
            ){
                val loginViewModel : LoginViewModel = hiltViewModel()

                val loginScreenState = LoginScreenState(
                    emailFieldState = loginViewModel.emailFieldState,
                    passwordFieldState = loginViewModel.passwordFieldState,
                    isPasswordVisibleState = loginViewModel.isPasswordVisibleState,
                    emailFieldStateError = loginViewModel.emailFieldStateError,
                    passwordFieldStateError = loginViewModel.passwordFieldStateError,
                    loginStateFlow = loginViewModel.loginStateFlow.collectAsState()
                )

                LoginScreen(
                    loginScreenEvents = loginViewModel::onEvent,
                    loginScreenState = loginScreenState
                )
            }
        }

        navigation(
            route = Route.HomeNavigation.route,
            startDestination = Route.HomeScreen.route
        ){
            composable(
                route = Route.HomeScreen.route
            ){
                val homeViewModel : HomeViewModel = hiltViewModel()

                val homeScreenStates = HomeScreenStates(
                    roomsStateFlow = homeViewModel.roomsStateFlow.collectAsState(),
                    tabRowSelectedIndex = homeViewModel.tabRowSelectedIndex
                )
                HomeScreen(
                    homeScreenEvents = homeViewModel::onEvent,
                    homeScreenStates = homeScreenStates,
                    navigateToScreen = {
                        navigateToScreen(navController, it)
                    }
                )
            }

            composable(
                route = Route.AddRoomScreen.route
            ){
                val addRoomViewModel : AddRoomViewModel = hiltViewModel()
                val addRoomScreenStates = AddRoomScreenStates(
                    roomNameState = addRoomViewModel.roomNameState,
                    roomDescription = addRoomViewModel.roomDescriptionState,
                    roomNameError = addRoomViewModel.roomNameError,
                    roomDescriptionError = addRoomViewModel.roomDescriptionError,
                    selectedRoomState = addRoomViewModel.selectedRoomState,
                    isDropMenuExpanded = addRoomViewModel.isDropMenuExpanded,
                    addRoomStateFlow = addRoomViewModel.addRoomStateFlow.collectAsState()
                )

                AddRoomScreen(
                    addRoomScreenStates = addRoomScreenStates,
                    addRoomScreenEvents = addRoomViewModel::onEvent,
                    navigateUp = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}

fun navigateToScreen(navController : NavHostController, route : String){
    navController.navigate(route)
}

@Composable
@Preview
fun PreviewNavGraph(){
    NavGraph("")
}