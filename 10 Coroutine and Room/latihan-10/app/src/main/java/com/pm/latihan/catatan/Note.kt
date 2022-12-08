package com.pm.latihan.catatan

import androidx.room.Entity
import androidx.room.PrimaryKey

//catatan/Note.kt
@Entity(tableName = "note_table")
data class Note(
    var title: String?,
    var tanggal: String?,
    var tanggalOtomatis: Boolean?,
    var description: String?,
    var priority: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}