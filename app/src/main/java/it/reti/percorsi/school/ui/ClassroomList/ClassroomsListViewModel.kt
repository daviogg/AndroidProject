package it.reti.percorsi.school.ui.ClassroomList

import android.app.Activity
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.subscribers.DisposableSubscriber
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.repository.SchoolRepository

class ClassroomsListViewModel(application: Activity) : ViewModel() {
    private val schoolRepository: SchoolRepository
    public val allClassrooms : LiveData<List<Classroom>>

    init {
        val schoolDao = SchoolDatabase.getDatabase(application).schoolDao()
        schoolRepository = SchoolRepository(schoolDao)
        allClassrooms = schoolRepository.getAllClassrooms()
    }

    fun getLocalClassrooms() {
        schoolRepository.getAllClassrooms()
    }


    @Suppress("UNCHECKED_CAST")
    class ClassroomsListViewModelFactory(private val application: Activity) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ClassroomsListViewModel(application) as T
        }
    }

}
