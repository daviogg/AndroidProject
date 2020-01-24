package it.reti.percorsi.school.ui.studentDetail

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import it.reti.percorsi.school.db.SchoolDatabase
import it.reti.percorsi.school.db.entities.Student
import it.reti.percorsi.school.db.entities.Vote
import it.reti.percorsi.school.db.repository.SchoolRepository

class StudentDetailViewModel(activity: Activity, studentId : Int) : ViewModel(){

    private val schoolRepository: SchoolRepository
    val student : LiveData<Student>

    init {
        val schoolDatabase = SchoolDatabase.buildDatabase(activity)
        schoolRepository = SchoolRepository(schoolDatabase)
        student = schoolRepository.getStudent(studentId)
    }

    fun getVotes(studentId: Int): LiveData<List<Vote>>{
        return schoolRepository.getAllVotes(studentId)
    }


    @Suppress("UNCHECKED_CAST")
    class StudentDetailViewModelFactory(private val application: Activity, private val studentId: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return StudentDetailViewModel(application, studentId) as T
        }
    }
}