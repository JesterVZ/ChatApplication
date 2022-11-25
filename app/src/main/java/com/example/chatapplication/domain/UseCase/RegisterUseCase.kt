package com.example.chatapplication.domain.UseCase

import com.example.chatapplication.domain.Repository.RegisterRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: RegisterRepository
) {
}