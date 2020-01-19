package it.reti.percorsi.school.ui.ClassroomList

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.repository.SchoolRepository

class ClassroomsListViewModel(application: Application) : ViewModel() {
    private val schoolRepository: SchoolRepository
    private val allClassrooms : LiveData<List<Classroom>>

    init {
        val schoolDao = SchoolDatabase.getDatabase(application).schoolDao()
        schoolRepository = SchoolRepository(schoolDao)
        allClassrooms = schoolRepository.allClassrooms
    }
}
