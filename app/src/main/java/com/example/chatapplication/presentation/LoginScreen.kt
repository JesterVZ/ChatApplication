package com.example.chatapplication.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.chatapplication.R
import com.example.chatapplication.domain.ViewModel.LoginViewModel
import com.example.chatapplication.presentation.UI.MainButton
import com.example.chatapplication.presentation.theme.BorderColor
import com.example.chatapplication.presentation.theme.Purple500
import com.example.chatapplication.presentation.theme.RedColor

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
){
    val state = viewModel.state.value;

    var loginText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(76.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 120.dp, height = 120.dp)
                    .background(color = Color.Transparent))
            if(state.error != null && state.error != ""){
                Box(modifier = Modifier
                    .background(color = RedColor)
                    .padding(15.dp)
                    .clip(shape = RoundedCornerShape(10.dp))){
                    Text(text = state.error, style = TextStyle(color = Color.White, fontSize = 16.sp))
                }
            }
            Column() {
                Text(text = "Login", modifier = Modifier.padding(8.dp));
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = loginText,
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = {loginText = it},
                    textStyle = TextStyle(fontSize = 18.sp),

                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Purple500,
                        unfocusedBorderColor = BorderColor,
                        disabledBorderColor = BorderColor,
                        disabledTextColor = BorderColor
                    ),
                    placeholder = {
                        Text(text = "login", style = TextStyle(fontSize = 18.sp, color = Color.LightGray))
                    }
                )
            }
            Column() {
                Text(text = "Password", modifier = Modifier.padding(8.dp));
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = passwordText,
                    shape = RoundedCornerShape(10.dp),
                    onValueChange = {passwordText = it},
                    textStyle = TextStyle(fontSize = 18.sp),
                    visualTransformation = PasswordVisualTransformation(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Purple500,
                        unfocusedBorderColor = BorderColor,
                        disabledBorderColor = BorderColor,
                        disabledTextColor = BorderColor
                    ),
                    placeholder = {
                        Text(text = "password", style = TextStyle(fontSize = 18.sp, color = Color.LightGray))
                    }
                )
            }
            MainButton(text = "Login", onClick = { viewModel.loginText = loginText; viewModel.passwordText = passwordText; viewModel.login() }, modifier = Modifier.padding(vertical = 35.dp))

            ClickableText(text = AnnotatedString("Forgot password?", ), onClick = {})
            ClickableText(text = AnnotatedString("Registration"), onClick = {})
        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }

    
}