package com.example.mvvmupgrade.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [NumberTrivia::class],version =  2 ,exportSchema = false)
abstract class NumberTriviaDatabase: RoomDatabase() {
    abstract fun numberTriviaDao(): NumberTriviaDao

    companion object{
        @Volatile
        private var INSTANCE: NumberTriviaDatabase? = null

        fun getDatabase(context: Context): NumberTriviaDatabase?{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,NumberTriviaDatabase::class.java,"NumberTriviaDatabase_2.db")
                    .build()

                INSTANCE = instance
                return INSTANCE
            }
        }
    }
}