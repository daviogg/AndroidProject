package it.reti.percorsi.school.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Classroom (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "students") val students: List<Student>,
    @ColumnInfo(name = "type") val type: ClassroomType)
