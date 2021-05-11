package com.rodolfo.infrastructure.repository

import retrofit2.Retrofit

interface RetrofitRepository {
    fun getRetrofit() : Retrofit
}