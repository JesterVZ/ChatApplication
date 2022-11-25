package com.example.chatapplication.presentation.State

import com.example.chatapplication.data.DTO.User

data class OperationState(
    val isLoading: Boolean = false,
    val result: Any? = null,
    val error: String? = "")