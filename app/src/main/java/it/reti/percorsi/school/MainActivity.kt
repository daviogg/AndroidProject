package it.reti.percorsi.school

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.ui.ClassroomList.ClassroomsListFragment


class MainActivity : AppCompatActivity(), ClassroomsListFragment.OnListFragmentInteractionListener {


    override fun onListFragmentInteraction(item: Classroom) {
        val v = item
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.nav_host_fragment)
    }
}
