package it.reti.percorsi.school.ui.studentDetail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import it.reti.percorsi.markerlibrary.Markable
import it.reti.percorsi.markerlibrary.MarkerMapView
import it.reti.percorsi.markerlibrary.TravelDelegateBase
import it.reti.percorsi.school.R
import it.reti.percorsi.school.databinding.StudentDetailBinding
import it.reti.percorsi.school.db.entities.Vote
import com.google.android.gms.maps.model.Marker
import it.reti.percorsi.school.db.entities.Student

class StudentDetailFragment: Fragment() {
    private var markerMapView: MarkerMapView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       /* val rootView: View =  inflater.inflate(R.layout.student_detail, container, false)*/
        val studentId = arguments?.getInt("student_id")
        var average : Double


        val viewModel = ViewModelProvider(
            this,
            StudentDetailViewModel.StudentDetailViewModelFactory(requireActivity(), studentId?:1)
        ).get(StudentDetailViewModel::class.java)


        val contentView = DataBindingUtil.inflate<StudentDetailBinding>(layoutInflater, R.layout.student_detail, container, false)

       /* val contentView = DataBindingUtil.setContentView<StudentDetailBinding>(
            requireActivity(),
            R.layout.student_detail
        )*/

        viewModel.student.observe(this, Observer {

            viewModel.getVotes(studentId?:1).observe(this, Observer { voteList ->
                average = calculateAverage(voteList)
                contentView.media = average
            })



            contentView.student = it
            contentView.vm = viewModel

            markerMapView = contentView.studentDetailMarkerMapView
            markerMapView?.travelDelegate = MyTravelDelegate()

            contentView.addressSearchBtn.setOnClickListener{ markerMapView?.syncMapWithDelegate(this.context!!) }

        })


        return contentView.root
    }


    interface OnListFragmentInteractionListener {
        fun onListFragmentInteraction(item: Student)
    }

    private inner class MyTravelDelegate: TravelDelegateBase() {

        override fun onGetTravel(): Collection<Markable> {
            val travel = ArrayList<Markable>()
            travel.add(MyMarkable("Busto Arsizio", 45.6134732, 8.8263221))
            travel.add(MyMarkable("Saronno", 45.6254773, 9.0164087))

            return travel
        }

        override fun onMarkerClick(marker: Marker): Boolean {
            return false
        }
    }

    private class MyMarkable(
        override val title: String, override val latitude: Double, override val longitude: Double
    ) : Markable

    private fun calculateAverage(votes : List<Vote>): Double{
        val numberOfVotes = votes.size
        var total = 0

        votes.forEach{
            total += it.value
        }

        return (total/numberOfVotes).toDouble()
    }



}