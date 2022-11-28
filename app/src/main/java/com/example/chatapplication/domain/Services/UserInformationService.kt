package com.example.chatapplication.domain.Services

import com.example.chatapplication.data.DTO.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserInformationService @Inject constructor() {
    var user: User? = null
}