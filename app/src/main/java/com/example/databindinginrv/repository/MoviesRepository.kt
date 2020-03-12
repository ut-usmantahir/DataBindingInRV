package com.example.databindinginrv.repository

import com.example.databindinginrv.network.MoviesApi
import com.example.databindinginrv.network.SafeApiRequest

class MoviesRepository(
    private val api: MoviesApi
): SafeApiRequest(){

    suspend fun getMovies() = apiRequest {api.getMovies()}
}