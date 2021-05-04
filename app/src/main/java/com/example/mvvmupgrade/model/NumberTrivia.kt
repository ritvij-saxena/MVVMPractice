package com.example.mvvmupgrade.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NumberTriviaTable")
 data class NumberTrivia(
    @NonNull
    val text: String,
    @PrimaryKey
    val number: Int,
    @NonNull
    val found: Boolean,
    @NonNull
    val type: String
)
