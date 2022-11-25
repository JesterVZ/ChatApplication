package com.example.chatapplication.domain.Repository

import com.example.chatapplication.data.DTO.User

interface RegisterRepository {
    suspend fun Register() : String
}