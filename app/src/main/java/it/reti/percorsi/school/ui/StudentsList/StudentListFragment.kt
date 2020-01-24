package it.reti.percorsi.school.ui.StudentsList

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import it.reti.percorsi.school.R
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student
import kotlinx.android.synthetic.main.list_student_fragment.*

class StudentListFragment : Fragment(){
    private var listener: OnListFragmentInteractionListener? = null
    companion object {
        fun newInstance() = StudentListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View =  inflater.inflate(R.layout.list_student_fragment, container, false)
        val classroomId = arguments?.getInt("classroom_id")

        val viewModel = ViewModelProvider(
            this,
            StudentListViewModel.StudentsListViewModelFactory(requireActivity(), classroomId?:1)
        ).get(StudentListViewModel::class.java)


            viewModel.allStudents.observe(this, Observer {list ->
                fragment_student_list_recycler.apply {
                    adapter = StudentListAdapter(this@StudentListFragment.context!!, list, listener)
                    layoutManager = LinearLayoutManager(this@StudentListFragment.context)
                }
            })

        return rootView
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Student)
    }
}