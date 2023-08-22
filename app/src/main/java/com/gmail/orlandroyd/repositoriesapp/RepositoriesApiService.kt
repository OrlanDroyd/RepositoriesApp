package com.gmail.orlandroyd.repositoriesapp

import retrofit2.http.GET
import retrofit2.http.Query


interface RepositoriesApiService {
    @GET("repositories?q=mobile&sort=stars&per_page=20")
    suspend fun getRepositories(@Query("page") page: Int): RepositoriesResponse
}