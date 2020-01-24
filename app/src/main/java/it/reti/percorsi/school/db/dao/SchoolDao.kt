package it.reti.percorsi.school.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student
import it.reti.percorsi.school.db.entities.Vote

@Dao
interface SchoolDao {

    @Query("SELECT * FROM Student WHERE classroomId == :classId")
    fun getAllStudents(classId: Int): LiveData<List<Student>>

    @Query("SELECT * FROM Classroom")
    fun getAllClassrooms(): LiveData<List<Classroom>>

    @Query("SELECT * FROM Student WHERE uid == :studentId")
    fun getStudent(studentId: Int): LiveData<Student>

    @Query("SELECT * FROM Vote WHERE uid == :studentId")
    fun getAllVotes(studentId: Int): LiveData<List<Vote>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertClassrooms(classrooms :  List<Classroom>) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertStudents(students: List<Student>) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVotes(votes:List<Vote>) : Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVote(votes:Vote) : Completable
}