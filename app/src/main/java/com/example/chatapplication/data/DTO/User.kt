package com.example.chatapplication.data.DTO

import java.math.BigInteger

data class User(
    val id: Int?,
    val login: String?,
    val email: String?,
    val status: String?,
    val phone: BigInteger?,
    val country: String?,
    val city: String?,
    val nickname: String?
){
}
