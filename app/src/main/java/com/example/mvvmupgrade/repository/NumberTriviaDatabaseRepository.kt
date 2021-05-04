package com.example.mvvmupgrade.repository

import androidx.lifecycle.LiveData
import com.example.mvvmupgrade.model.NumberTrivia
import com.example.mvvmupgrade.model.NumberTriviaDao


class NumberTriviaDatabaseRepository (private var numberTriviaDao: NumberTriviaDao){
    val allTrivia: LiveData<List<NumberTrivia>> = numberTriviaDao.getAllTrivia()

    suspend fun insertTrivia(numberTrivia: NumberTrivia){
        numberTriviaDao.insertTrivia(numberTrivia)
    }

    suspend fun deleteTrivia(numberTrivia: NumberTrivia){
        numberTriviaDao.deleteTrivia(numberTrivia)
    }
}