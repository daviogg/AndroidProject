package it.reti.percorsi.school.db.dao

import androidx.room.Dao
import androidx.room.Query
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Exam
import it.reti.percorsi.school.db.entities.Student

@Dao
interface SchoolDao {

    @Query("SELECT * FROM Student")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM Classroom")
    fun getAllClassrooms(): List<Classroom>

    @Query("SELECT * FROM Exam")
    fun getAllExams(): List<Exam>

    
}