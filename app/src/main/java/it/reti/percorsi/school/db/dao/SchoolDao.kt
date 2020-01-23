package it.reti.percorsi.school.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student

@Dao
interface SchoolDao {

    @Query("SELECT * FROM Student WHERE classroomId == :classId")
    fun getAllStudents(classId: Int): LiveData<List<Student>>

    @Query("SELECT * FROM Classroom")
    fun getAllClassrooms(): LiveData<List<Classroom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClassrooms(classrooms :  List<Classroom>) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudents(student: List<Student>) : Completable

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertExam(exam: Exam) : Completable*/
}