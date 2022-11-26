package com.example.chatapplication.domain.UseCase

import com.example.chatapplication.common.Resource
import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User
import com.example.chatapplication.domain.Repository.LoginRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    operator fun invoke(loginData: LoginData): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading<User>())
            val token = repository.Login(loginData)
            //val user: User = repository.Auth(token)
            //emit(Resource.Success<User>(user))
            //emit(Resource.Error<User>("An unexpected error occured!"))
        }catch(e: HttpException) {
            emit(Resource.Error<User>(e.localizedMessage ?: "An unexpected error occured!"))
        }catch(e: IOException) {
            emit(Resource.Error<User>(e.localizedMessage))
        }
    }
}