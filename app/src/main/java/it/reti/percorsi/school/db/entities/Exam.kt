package it.reti.percorsi.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Exam (
    @PrimaryKey val uid: UUID,
    @ColumnInfo(name = "vote") val vote: Int,
    @ColumnInfo(name = "name") val name: String)