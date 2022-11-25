package com.example.chatapplication.data.Repository

import com.example.chatapplication.data.DTO.RegisterData
import com.example.chatapplication.data.DTO.User
import com.example.chatapplication.data.api.RegisterAPI
import com.example.chatapplication.domain.Repository.RegisterRepository
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(private val api: RegisterAPI) : RegisterRepository {
    override suspend fun Register(): String {
        return ""
    }

}