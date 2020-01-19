package it.reti.percorsi.school.ui.ClassroomList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import it.reti.percorsi.school.R

class ClassroomsList : Fragment() {

    companion object {
        fun newInstance() = ClassroomsList()
    }

    private lateinit var viewModel: ClassroomsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.classrooms_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ClassroomsListViewModel::class.java)
    }

}
