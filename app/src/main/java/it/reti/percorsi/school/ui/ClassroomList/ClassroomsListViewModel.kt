package it.reti.percorsi.school.ui.ClassroomList

import android.app.Activity
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.reactivex.subscribers.DisposableSubscriber
import it.reti.percorsi.school.db.PopulateDb
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.dao.SchoolDao
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.repository.SchoolRepository
import kotlinx.android.synthetic.main.list_classroom_fragment.*
import java.util.concurrent.Executors

class ClassroomsListViewModel(application: Activity) : ViewModel() {
    private val schoolRepository: SchoolRepository
    private val allClassrooms : LiveData<List<Classroom>>

    init {
        val schoolDatabase = SchoolDatabase.buildDatabase(application)
        schoolRepository = SchoolRepository(schoolDatabase)
        populateDatabaseIfNull()
        allClassrooms = schoolRepository.getAllClassrooms()
    }

    fun getLocalClassrooms(): LiveData<List<Classroom>> {
        return schoolRepository.getAllClassrooms()
    }

    fun populateDatabaseIfNull(){
            SchoolDatabase.let {
                schoolRepository
                    .insertStudents(PopulateDb.generateStudentsClassA(schoolRepository))
                schoolRepository
                    .insertStudents(PopulateDb.generateStudentsClassB(schoolRepository))
                schoolRepository
                    .insertStudents(PopulateDb.generateStudentsClassC(schoolRepository))
                schoolRepository
                    .insertStudents(PopulateDb.generateStudentsClassD(schoolRepository))
                schoolRepository
                    .insertStudents(PopulateDb.generateStudentsClassE(schoolRepository))
                schoolRepository
                    .insertClassrooms(PopulateDb.generateClassrooms(schoolRepository))
            }
    }


    @Suppress("UNCHECKED_CAST")
    class ClassroomsListViewModelFactory(private val application: Activity) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ClassroomsListViewModel(application) as T
        }
    }

}
