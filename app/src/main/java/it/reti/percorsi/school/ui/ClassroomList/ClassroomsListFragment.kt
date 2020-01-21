package it.reti.percorsi.school.ui.ClassroomList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import io.reactivex.subscribers.DisposableSubscriber

import it.reti.percorsi.school.R
import it.reti.percorsi.school.db.entities.Classroom
import java.util.concurrent.TimeUnit

class ClassroomsListFragment : Fragment() {

    companion object {
        fun newInstance() = ClassroomsListFragment()
    }

    private lateinit var viewModel: ClassroomsListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View =  inflater.inflate(R.layout.list_classroom_fragment, container, false)

        rootView.findViewById<AppCompatImageButton>(R.id.products_search_btn).setOnClickListener {
            viewModel.getLocalClassrooms()
        }

        return rootView
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val viewModel = ViewModelProvider(
            requireActivity(),
            ClassroomsListViewModel.ClassroomsListViewModelFactory(requireActivity())
        ).get(ClassroomsListViewModel::class.java)

        viewModel.allClassrooms.observe(viewLifecycleOwner, Observer {
            updateViews(it)
        })
    }

    private fun updateViews(classrooms: List<Classroom>) {
        // Set the adapter
        val v = view?.findViewById<RecyclerView>(R.id.fragment_classroom_list_recycler)
    }
}
