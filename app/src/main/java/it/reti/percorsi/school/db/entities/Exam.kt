package it.reti.percorsi.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Exam (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "vote") val vote: Int,
    @ColumnInfo(name = "name") val name: String)