package com.pm.latihan.catatan

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class Note(
    var title: String?,
    var tanggal: String?,
    var description: String?,
    var priority: Boolean
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}