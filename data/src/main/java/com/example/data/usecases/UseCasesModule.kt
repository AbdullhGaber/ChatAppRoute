package com.example.data.usecases

import com.example.domain.repositories.AuthRepository
import com.example.domain.repositories.UserRepository
import com.example.domain.usecases.auth_usecases.AuthUseCases
import com.example.domain.usecases.auth_usecases.LoginUseCase
import com.example.domain.usecases.auth_usecases.RegisterUseCase
import com.example.domain.usecases.user_usecases.GetUserUseCase
import com.example.domain.usecases.user_usecases.SaveUserUseCase
import com.example.domain.usecases.user_usecases.UserUseCases
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
            loginUseCase = LoginUseCase(authRepository),
            registerUseCase = RegisterUseCase(authRepository)
        )
    }

    @Provides
    fun provideUserUseCases(userRepository: UserRepository) : UserUseCases {
        return UserUseCases(
           saveUserUseCase = SaveUserUseCase(userRepository),
           getUserUseCase = GetUserUseCase(userRepository)
        )
    }
}