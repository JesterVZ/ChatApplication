package com.example.chatapplication.DI

import com.example.chatapplication.common.ViewModel.Constants
import com.example.chatapplication.data.Repository.LoginRepositoryImpl
import com.example.chatapplication.data.Repository.RegisterRepositoryImpl
import com.example.chatapplication.data.api.LoginAPI
import com.example.chatapplication.data.api.RegisterAPI
import com.example.chatapplication.domain.Repository.LoginRepository
import com.example.chatapplication.domain.Repository.RegisterRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLoginAPI(): LoginAPI{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(LoginAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRegisterAPI(): RegisterAPI{
        return Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(RegisterAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(api: LoginAPI): LoginRepository{
        return LoginRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRegisterRepository(api: RegisterAPI): RegisterRepository {
        return RegisterRepositoryImpl(api)
    }
}