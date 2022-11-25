package com.example.chatapplication.data.Repository

import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User
import com.example.chatapplication.data.api.LoginAPI
import com.example.chatapplication.domain.Repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val api: LoginAPI
) : LoginRepository {
    override suspend fun Auth(token: String): User {
        return api.Autn(token);
    }

    override suspend fun Login(loginData: LoginData): String {
        return api.Login(loginData)
    }
}