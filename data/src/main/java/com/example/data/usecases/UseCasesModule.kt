package com.example.data.usecases

import com.example.domain.repositories.AuthRepository
import com.example.domain.usecases.auth_usecases.AuthUseCases
import com.example.domain.usecases.auth_usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCasesModule {
    @Provides
    fun provideAuthUseCases(authRepository: AuthRepository) : AuthUseCases{
        return AuthUseCases(
            loginUseCase = LoginUseCase(authRepository)
        )
    }
}