package com.example.chatapplication.data.api

import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User

interface LoginAPI {
    suspend fun Login(loginData: LoginData) : String //вернет токен
    suspend fun Autn(token: String): User
}