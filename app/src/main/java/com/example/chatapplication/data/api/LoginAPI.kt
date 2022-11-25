package com.example.chatapplication.data.api

import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginAPI {

    @POST("/login")
    suspend fun Login(@Body loginData: LoginData) : String //вернет токен

    @POST("/auth")
    suspend fun Autn(token: String): User
}