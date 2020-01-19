package it.reti.percorsi.school.db.repository

import androidx.lifecycle.LiveData
import it.reti.percorsi.school.db.dao.SchoolDao
import it.reti.percorsi.school.db.entities.Classroom

class SchoolRepository(private val schoolDao: SchoolDao) {

    val allClassrooms: LiveData<List<Classroom>> = schoolDao.getAllClassrooms()
}