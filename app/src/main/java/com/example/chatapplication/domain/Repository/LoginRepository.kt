package com.example.chatapplication.domain.Repository

import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User
import javax.inject.Inject

interface LoginRepository {
    suspend fun Login(loginData: LoginData): String
    suspend fun Auth(token: String): User
}