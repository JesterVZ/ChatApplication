package com.example.chatapplication.data.Repository

import com.example.chatapplication.common.Resource
import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User
import com.example.chatapplication.data.api.LoginAPI
import com.example.chatapplication.domain.Repository.LoginRepository
import com.google.gson.internal.LinkedTreeMap
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: LoginAPI
) : LoginRepository {
    override suspend fun Auth(token: String): User {
        return api.Autn(token);
    }

    override suspend fun Login(loginData: LoginData): String {
        val response: Response<Any> =  api.Login(loginData)
        if(response.isSuccessful){
            val token: String = (response.body() as LinkedTreeMap<*, *>).get("data") as String
            return token;
        }else {
            throw Exception("Error")
        }
    }
}