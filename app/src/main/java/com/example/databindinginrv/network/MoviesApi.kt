package com.example.databindinginrv.network

import com.example.databindinginrv.model.Movie
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {
    @GET("marvel")
   suspend fun getMovies(): Response<List<Movie>>
    companion object {
        operator fun invoke(): MoviesApi {
           return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.simplifiedcoding.net/demos/")
                .build()
                .create(MoviesApi::class.java)
        }
    }
}

//  BASE_URL  https://api.simplifiedcoding.in/course-apis/recyclerview/
