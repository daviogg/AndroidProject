package it.reti.percorsi.school

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student
import it.reti.percorsi.school.ui.ClassroomList.ClassroomsListFragment
import it.reti.percorsi.school.ui.StudentsList.StudentListFragment


class MainActivity : AppCompatActivity(), ClassroomsListFragment.OnListFragmentInteractionListener, StudentListFragment.OnListFragmentInteractionListener{


    override fun onListFragmentInteraction(item: Classroom) {
        val bundle = bundleOf("classroom_id" to item.uid)
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_classroom_list_to_student_list, bundle)
    }

    override fun onListFragmentInteraction(item: Student) {
        val bundle = bundleOf("student_id" to item.uid)
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_student_list_to_student_detail, bundle)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
    }
}
