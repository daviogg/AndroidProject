package it.reti.percorsi.school.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Exam
import it.reti.percorsi.school.db.entities.Student

@Dao
interface SchoolDao {

    @Query("SELECT * FROM Student")
    fun getAllStudents(): List<Student>

    @Query("SELECT * FROM Classroom")
    fun getAllClassrooms(): LiveData<List<Classroom>>

    @Query("SELECT * FROM Exam")
    fun getAllExams(): List<Exam>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClassrooms(classrooms :  List<Classroom>) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudent(student: Student) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExam(exam: Exam) : Completable
}