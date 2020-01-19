package it.reti.percorsi.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import it.reti.percorsi.school.db.entities.Exam
import java.util.*

@Entity
data class Student (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "votes") val votes: List<Exam>)

