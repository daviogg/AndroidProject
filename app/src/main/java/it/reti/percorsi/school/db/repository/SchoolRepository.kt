package it.reti.percorsi.school.db.repository

import android.util.Log
import androidx.lifecycle.LiveData
import io.reactivex.Flowable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.dao.SchoolDao
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student
import io.reactivex.android.schedulers.AndroidSchedulers

class SchoolRepository(private val schoolDatabase: SchoolDatabase) {

    fun getAllClassrooms(): LiveData<List<Classroom>> {
        return schoolDatabase.schoolDao().getAllClassrooms()
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

    fun insertStudents(student: List<Student>): DisposableCompletableObserver {
        return schoolDatabase.schoolDao().insertStudents(
            student
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