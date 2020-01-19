package it.reti.percorsi.school.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.repository.SchoolRepository

class SchoolViewModel(application: Application):AndroidViewModel(application) {

    private val schoolRepository: SchoolRepository
    private val allClassrooms : LiveData<List<Classroom>>

    init {
        val schoolDao = SchoolDatabase.getDatabase(application).schoolDao()
        schoolRepository = SchoolRepository(schoolDao)
        allClassrooms = schoolRepository.allClassrooms
    }
}