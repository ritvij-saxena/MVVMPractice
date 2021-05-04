package com.example.mvvmupgrade.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmupgrade.model.NumberTrivia
import com.example.mvvmupgrade.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object NumberTriviaRepository {
    private val trivia = MutableLiveData<NumberTrivia>()

    fun getRandomTrivia(): MutableLiveData<NumberTrivia>{
        val call = RetrofitClient.apiInterface.getRandomTrivia()
        call.enqueue(object : Callback<NumberTrivia>{
            override fun onFailure(call: Call<NumberTrivia>, t: Throwable) {
                Log.e("ERROR",t.message.toString())
            }

            override fun onResponse(call: Call<NumberTrivia>, response: Response<NumberTrivia>) {
                Log.v("DEBUG",response.body().toString())
                val data = response.body()
                trivia.value = data
            }

        })
        return trivia
    }

    fun getTrivia(url:String): MutableLiveData<NumberTrivia>{
        val call = RetrofitClient.apiInterface.getTrivia(url)
        call.enqueue(object : Callback<NumberTrivia>{
            override fun onFailure(call: Call<NumberTrivia>, t: Throwable) {
                Log.e("ERROR",t.message.toString())
            }

            override fun onResponse(call: Call<NumberTrivia>, response: Response<NumberTrivia>) {
                Log.v("DEBUG",response.body().toString())
                val data = response.body()
                trivia.value = data
            }
        })
        return trivia
    }
}