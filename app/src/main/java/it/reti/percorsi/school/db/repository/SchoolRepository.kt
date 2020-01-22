package it.reti.percorsi.school.db.repository

import androidx.lifecycle.LiveData
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.dao.SchoolDao
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student

class SchoolRepository(private val schoolDao: SchoolDao) {

    fun getAllClassrooms(): LiveData<List<Classroom>> {
        return schoolDao.getAllClassrooms()
    }
}