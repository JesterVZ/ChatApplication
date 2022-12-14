package com.example.chatapplication.presentation.Screens

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
}