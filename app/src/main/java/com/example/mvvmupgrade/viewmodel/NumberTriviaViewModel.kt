package com.example.mvvmupgrade.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmupgrade.model.NumberTrivia
import com.example.mvvmupgrade.model.NumberTriviaDao
import com.example.mvvmupgrade.model.NumberTriviaDatabase
import com.example.mvvmupgrade.repository.NumberTriviaDatabaseRepository
import com.example.mvvmupgrade.repository.NumberTriviaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NumberTriviaViewModel : ViewModel() {
    var trivia: MutableLiveData<NumberTrivia>? = null
    lateinit var listOfTrivia : LiveData<List<NumberTrivia>>
    lateinit var databaseRepository: NumberTriviaDatabaseRepository
    private lateinit var numberTriviaDao: NumberTriviaDao



    fun getRandomTrivia(): LiveData<NumberTrivia>? {
        trivia = NumberTriviaRepository.getRandomTrivia()
        return trivia
    }

    fun getTrivia(url:String): LiveData<NumberTrivia>? {
        trivia = NumberTriviaRepository.getTrivia(url)
        return trivia
    }


    fun setDatabaseRepository(context: Context){
        numberTriviaDao = NumberTriviaDatabase.getDatabase(context)!!.numberTriviaDao()
        databaseRepository = NumberTriviaDatabaseRepository(numberTriviaDao)
        listOfTrivia = databaseRepository.allTrivia
    }

    fun insertTrivia(numberTrivia: NumberTrivia) {
        Log.v("DEBUG: ITVM",numberTrivia.toString())
        viewModelScope.launch(Dispatchers.IO){
            databaseRepository.insertTrivia(numberTrivia)
        }
    }

    fun deleteTrivia(numberTrivia: NumberTrivia){
        viewModelScope.launch(Dispatchers.IO) {
            databaseRepository.deleteTrivia(numberTrivia)
        }
    }
}