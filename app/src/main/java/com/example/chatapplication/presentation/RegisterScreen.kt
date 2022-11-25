package com.example.chatapplication.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chatapplication.domain.ViewModel.RegisterViewModel

@Composable
fun RegisterScreen(
    navController: NavController,
){
    Text(text = "Register screen")
}