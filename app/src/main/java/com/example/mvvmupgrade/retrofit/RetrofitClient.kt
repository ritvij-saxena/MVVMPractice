package com.example.mvvmupgrade.retrofit

import com.example.mvvmupgrade.model.NumberTrivia
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // Singleton RetrofitClient

    private const val BASE_URL: String = "http://numbersapi.com/"
    private val retrofitBuilder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())

    val apiInterface: ApiInterface by lazy {
        retrofitBuilder
            .build()
            .create(ApiInterface::class.java)
    }
}