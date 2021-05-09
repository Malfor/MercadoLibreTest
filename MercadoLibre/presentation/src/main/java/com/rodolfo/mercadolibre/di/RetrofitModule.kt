package com.rodolfo.mercadolibre.di

import com.rodolfo.infrastructure.repository.RetrofitRepository
import com.rodolfo.infrastructure.repository.RetrofitRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RetrofitModule {

    @Binds
    abstract fun bindRetrofitRepository(retrofitRepository: RetrofitRepositoryImpl) : RetrofitRepository
}