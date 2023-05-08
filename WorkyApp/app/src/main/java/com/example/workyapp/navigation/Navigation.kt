package com.example.workyapp.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavController
import androidx.navigation.NavHostController

class Navigation (private val navController: NavHostController){

    sealed class Screen(val route: String){
        object LoginScreen : Screen("loginScreen")
        object RegisterScreen : Screen("registerScreen")
        object HomeScreen : Screen("homeScreen")
    }

    var currentScreen : Screen by mutableStateOf(Screen.LoginScreen)
    fun navigateTo(screen:Screen){
        if(screen != currentScreen){
            currentScreen = screen
            navController.navigate(screen.route)
        }
    }
    fun navigateBack(){
        navController.popBackStack()
    }
}