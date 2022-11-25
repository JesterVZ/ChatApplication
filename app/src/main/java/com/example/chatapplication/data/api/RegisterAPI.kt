package com.example.chatapplication.data.api

import com.example.chatapplication.data.DTO.RegisterData

interface RegisterAPI {
    suspend fun Register(data: RegisterData): Void
}