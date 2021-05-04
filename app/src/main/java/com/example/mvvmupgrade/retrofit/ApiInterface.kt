package com.example.mvvmupgrade.retrofit

import com.example.mvvmupgrade.model.NumberTrivia
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET("random/trivia?json")
    fun getRandomTrivia(): Call<NumberTrivia>

    @GET
    fun getTrivia(@Url url:String): Call<NumberTrivia>
}