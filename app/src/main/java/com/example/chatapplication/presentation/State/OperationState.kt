package com.example.chatapplication.presentation.State

data class OperationState (
    val isLoading: Boolean = false,
    val result: Object,
    val error: String = "")