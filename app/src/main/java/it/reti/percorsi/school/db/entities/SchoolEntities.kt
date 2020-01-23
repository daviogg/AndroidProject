package it.reti.percorsi.school.db.entities

import androidx.room.*
import java.util.*

@Entity
data class Classroom(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo val studentIds: List<Int>,
    @ColumnInfo(name = "type") val type: ClassroomType,
    @ColumnInfo(name = "section") val section: String
)

@Entity
data class Student (
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "classroomId") val classroomId: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double,
    @ColumnInfo(name = "votes") val votes: List<Int>)

data class ClassroomWithStudents(
    @Embedded val classroom: Classroom,
    @Relation(
        parentColumn = "uid",
        entityColumn = "classroomId"
    )
    val students: List<Student>
)

/*
@Entity
data class Exam (
    @PrimaryKey val uid: UUID,
    @ColumnInfo(name = "vote") val vote: Int,
    @ColumnInfo(name = "name") val name: String)*/


/*class Students{
    private var students: List<Int>? = null

    fun students(students: List<Int>?) {
        this.students = students
    }

    fun getStudents(): List<Int>? {
        return students
    }

    fun setStudents(students: List<Int>?) {
        this.students = students
    }
}

class Votes{
    private var votes: List<Int>? = null

    fun votes(classrooms: List<Int>?) {
        this.votes = votes
    }

    fun getVotes(): List<Int>? {
        return votes
    }

    fun setVotes(votes: List<Int>?) {
        this.votes = votes
    }
}*/


