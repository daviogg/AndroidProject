package it.reti.percorsi.school.ui.studentDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import it.reti.percorsi.school.R
import it.reti.percorsi.school.databinding.StudentDetailBinding
import it.reti.percorsi.school.db.entities.Vote

class StudentDetailFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View =  inflater.inflate(R.layout.list_student_fragment, container, false)
        val studentId = arguments?.getInt("student_id")
        var votes: List<Vote> = mutableListOf()
        var average : Double

        val viewModel = ViewModelProvider(
            this,
            StudentDetailViewModel.StudentDetailViewModelFactory(requireActivity(), studentId?:1)
        ).get(StudentDetailViewModel::class.java)


        viewModel.student.observe(this, Observer {
            val contentView = DataBindingUtil.setContentView<StudentDetailBinding>(
                requireActivity(),
                R.layout.student_detail
            )

            viewModel.getVotes(studentId?:1).observe(this, Observer {
                votes = it
                average = calculateAverage(it)
                contentView.media = average
            })

            //This is to show the student
            contentView.student = it
            contentView.vm = viewModel
        })


        return rootView
    }

    fun calculateAverage(votes : List<Vote>): Double{
        val numberOfVotes = votes.size
        var total : Int = 0

        votes.forEach{
            total += it.value
        }

        return (total/numberOfVotes).toDouble()
    }
}