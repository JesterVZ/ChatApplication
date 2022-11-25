package com.example.chatapplication.data.DTO

import java.math.BigInteger

data class RegisterData (val login: String, val nickname: String, val email: String, val password: String, val phone: BigInteger, val country: String, val city: String)