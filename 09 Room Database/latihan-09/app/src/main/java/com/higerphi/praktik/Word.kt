package com.higerphi.praktik

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//word.kt
@Entity(tableName="word_table")
data class Word(
    @PrimaryKey @ColumnInfo(name = "word")
    val word: String
)