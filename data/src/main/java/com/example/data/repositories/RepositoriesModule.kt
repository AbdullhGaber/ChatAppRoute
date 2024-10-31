package com.example.data.repositories

import com.example.data.data_source.auth.AuthRemoteDataSourceImpl
import com.example.data.data_source.user.UserRemoteDataSourceImpl
import com.example.data.repositories.auth.AuthRepositoryImpl
import com.example.data.repositories.user.UserRepositoryImpl
import com.example.domain.repositories.AuthRemoteDataSource
import com.example.domain.repositories.AuthRepository
import com.example.domain.repositories.UserRemoteDataSource
import com.example.domain.repositories.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideAuthRemoteDataSource(authRemoteDataSourceImpl: AuthRemoteDataSourceImpl) : AuthRemoteDataSource

    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl) : AuthRepository

    @Binds
    abstract fun provideUserRemoteDataSource(userRemoteDataSource: UserRemoteDataSourceImpl) : UserRemoteDataSource

    @Binds
    abstract fun provideUserRepository(userRepositoryImpl: UserRepositoryImpl) : UserRepository

}