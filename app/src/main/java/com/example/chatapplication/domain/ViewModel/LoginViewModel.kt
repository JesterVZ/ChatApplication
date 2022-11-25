package com.example.chatapplication.domain.ViewModel

import androidx.lifecycle.ViewModel
import com.example.chatapplication.common.ViewModel.BaseViewModel
import com.example.chatapplication.domain.UseCase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginUseCase: LoginUseCase) : ViewModel() {
    var loginText: String = ""
    var passwordText: String = ""
    fun Login(){
        //loginUseCase.invoke()
    }


}