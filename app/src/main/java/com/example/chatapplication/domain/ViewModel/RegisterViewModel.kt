package com.example.chatapplication.domain.ViewModel

import androidx.lifecycle.ViewModel
import com.example.chatapplication.common.ViewModel.BaseViewModel
import com.example.chatapplication.domain.UseCase.RegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) : ViewModel() {
}