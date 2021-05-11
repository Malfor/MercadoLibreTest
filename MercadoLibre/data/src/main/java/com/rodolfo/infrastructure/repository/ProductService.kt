package com.rodolfo.infrastructure.repository

import com.rodolfo.infrastructure.dto.SearchDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("/sites/MLA/search")
    suspend fun getProducts(@Query("q") search: String? = "") : Response<SearchDto>
}