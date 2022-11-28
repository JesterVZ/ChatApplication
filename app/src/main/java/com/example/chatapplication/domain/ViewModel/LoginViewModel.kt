package com.example.chatapplication.domain.ViewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatapplication.common.Resource
import com.example.chatapplication.data.DTO.LoginData
import com.example.chatapplication.data.DTO.User
import com.example.chatapplication.domain.Services.UserInformationService
import com.example.chatapplication.domain.UseCase.LoginUseCase
import com.example.chatapplication.presentation.State.OperationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _state = mutableStateOf(OperationState())
    val state: State<OperationState> = _state

    @Inject
    lateinit var userInformationService: UserInformationService

    var loginText: String = ""
    var passwordText: String = ""
    fun login(){
        try {
            loginUseCase(LoginData(loginText, passwordText)).onEach { result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = OperationState(result = result.data)
                        userInformationService.user = result.data
                    }
                    is Resource.Error -> {
                        _state.value = OperationState(error =  result.message ?: "An unexpected error occured")
                    }
                    is Resource.Loading -> {
                        _state.value = OperationState(isLoading = true)
                    }
                }

            }.launchIn(viewModelScope)
        }catch (e: Exception){
            print(e)
        }

    }


}