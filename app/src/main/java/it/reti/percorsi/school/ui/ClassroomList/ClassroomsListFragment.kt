package it.reti.percorsi.school.ui.ClassroomList

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import it.reti.percorsi.school.R
import it.reti.percorsi.school.db.entities.Classroom
import kotlinx.android.synthetic.main.list_classroom_fragment.*

class ClassroomsListFragment : Fragment() {

    private var listener: OnListFragmentInteractionListener? = null
    companion object {
        fun newInstance() = ClassroomsListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View =  inflater.inflate(R.layout.list_classroom_fragment, container, false)

         val viewModel = ViewModelProvider(
            this,
            ClassroomsListViewModel.ClassroomsListViewModelFactory(requireActivity())
        ).get(ClassroomsListViewModel::class.java)

        viewModel.getLocalClassrooms().observe(this, Observer {list ->
            fragment_classroom_list_recycler.apply {
                adapter = ClassroomListAdapter(this@ClassroomsListFragment.context!!, list, listener)
                layoutManager = LinearLayoutManager(this@ClassroomsListFragment.context)
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
        fun onListFragmentInteraction(item: Classroom)
    }
}
