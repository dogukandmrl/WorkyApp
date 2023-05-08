package com.example.workyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.workyapp.navigation.Navigation
import com.example.workyapp.screen.HomeScreen
import com.example.workyapp.screen.LoginScreen
import com.example.workyapp.screen.RegisterScreen
import com.example.workyapp.ui.theme.WorkyAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkyAppTheme {
              NavigatorFun()
            }
        }
    }
    @ExperimentalFoundationApi
    @Composable
    fun NavigatorFun() {
        val navController = rememberNavController()
        val navigation = Navigation(navController)

        MaterialTheme {
            NavHost(navController = navController, startDestination = Navigation.Screen.LoginScreen.route ){
                composable(Navigation.Screen.LoginScreen.route){
                    LoginScreen(navController)
                }
                composable(Navigation.Screen.RegisterScreen.route){
                    RegisterScreen(navController)
                }
                composable(Navigation.Screen.HomeScreen.route){
                    HomeScreen(navController)
                }

            }
        }
    }
}

