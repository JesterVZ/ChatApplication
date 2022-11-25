package com.example.chatapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chatapplication.R
import com.example.chatapplication.domain.ViewModel.LoginViewModel
import com.example.chatapplication.presentation.UI.MainButton
import com.example.chatapplication.presentation.UI.MainInput
import com.example.chatapplication.presentation.theme.BorderColor

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(76.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
        modifier = Modifier
            .size(width = 120.dp, height = 120.dp)
            .background(color = Color.Transparent))
        MainInput(label = "Login", text = viewModel.loginText, placeholder = "Login")
        MainInput(label = "Password", text = viewModel.passwordText, placeholder = "Password", transformation = PasswordVisualTransformation())
        MainButton(text = "Login", onClick = { viewModel.Login() }, modifier = Modifier.padding(vertical = 35.dp))

    }
}