package com.example.mvvmupgrade.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NumberTriviaDao {
    @Insert
    suspend fun insertTrivia(numberTrivia: NumberTrivia)

    @Query("SELECT * FROM NumberTriviaTable")
    fun getAllTrivia(): LiveData<List<NumberTrivia>>

    @Delete
    suspend fun deleteTrivia(numberTrivia: NumberTrivia)
}