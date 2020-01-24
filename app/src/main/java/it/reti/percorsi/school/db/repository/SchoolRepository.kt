package it.reti.percorsi.school.db.repository

import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student
import io.reactivex.android.schedulers.AndroidSchedulers
import it.reti.percorsi.school.db.entities.Vote

class SchoolRepository(private val schoolDatabase: SchoolDatabase) {

    fun getAllClassrooms(): LiveData<List<Classroom>> {
        return schoolDatabase.schoolDao().getAllClassrooms()
    }

    fun getAllStudents(classId: Int): LiveData<List<Student>>{
        return schoolDatabase.schoolDao().getAllStudents(classId)
    }

    fun getAllVotes(studentId: Int): LiveData<List<Vote>>{
        return schoolDatabase.schoolDao().getAllVotes(studentId)
    }

    fun getStudent(studentId: Int): LiveData<Student>{
        return schoolDatabase.schoolDao().getStudent(studentId)
    }

    fun insertClassrooms(classrooms: List<Classroom>): DisposableCompletableObserver {
        return schoolDatabase.schoolDao().insertClassrooms(
                classrooms
            )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableCompletableObserver() {
                    override fun onStart() {
                    }
                    override fun onError(error: Throwable) {
                        Log.d("TAG", error.message)
                    }
                    override fun onComplete() {
                        Log.d("TAG", "")
                    }
            })
    }

    fun insertStudents(students: List<Student>): DisposableCompletableObserver {
        return schoolDatabase.schoolDao().insertStudents(
            students
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableCompletableObserver() {
                override fun onStart() {

                }
                override fun onError(error: Throwable) {
                    Log.d("TAG", error.message)
                }
                override fun onComplete() {
                    Log.d("TAG", "")
                }
            })
    }

    fun insertVote(vote: Vote): DisposableCompletableObserver {
        return schoolDatabase.schoolDao().insertVote(
            vote
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableCompletableObserver() {
                override fun onStart() {

                }
                override fun onError(error: Throwable) {
                    Log.d("TAG", error.message)
                }
                override fun onComplete() {
                    Log.d("TAG", "")
                }
            })
    }


}