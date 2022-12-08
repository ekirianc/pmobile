package com.higerphi.praktik

import androidx.lifecycle.LiveData

//WordRepository.kt
class WordRepository (private val wordDao: WordDao){
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()
    suspend fun insert(word: Word){
        wordDao.insert(word)
    }
}