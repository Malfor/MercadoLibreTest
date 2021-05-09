package com.rodolfo.mercadolibre.di

import com.rodolfo.domain.repository.ProductRepository
import com.rodolfo.infrastructure.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ProductModule {

    @Binds
    abstract fun bindProductRepository(productRepository: ProductRepositoryImpl) : ProductRepository
}