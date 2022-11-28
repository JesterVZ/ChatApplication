package com.example.chatapplication.data.api

import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginAPI {

    @POST("login")
    suspend fun Login(@Body loginData: LoginData) : Response<Any> //вернет токен

    @POST("auth")
    suspend fun Autn(@Header("Authorization") token: String): Response<Any>
}