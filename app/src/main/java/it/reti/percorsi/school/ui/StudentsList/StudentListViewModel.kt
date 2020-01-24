package it.reti.percorsi.school.ui.StudentsList

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.entities.Student
import it.reti.percorsi.school.db.repository.SchoolRepository

class StudentListViewModel(activity: Activity, classroomId : Int) :ViewModel(){

    private val schoolRepository: SchoolRepository
    val allStudents : LiveData<List<Student>>

    init {
        val schoolDatabase = SchoolDatabase.buildDatabase(activity)
        schoolRepository = SchoolRepository(schoolDatabase)
        allStudents = schoolRepository.getAllStudents(classroomId)
    }


    @Suppress("UNCHECKED_CAST")
    class StudentsListViewModelFactory(private val application: Activity, private val classroomId: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return StudentListViewModel(application, classroomId) as T
        }
    }
}