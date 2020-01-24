package it.reti.percorsi.school.ui.StudentsList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.reti.percorsi.school.R
import it.reti.percorsi.school.db.entities.Classroom
import it.reti.percorsi.school.db.entities.Student

class StudentListAdapter internal constructor(
    context: Context,
    studentsCtor: List<Student>,
    private val listener: StudentListFragment.OnListFragmentInteractionListener?
) : RecyclerView.Adapter<StudentListAdapter.StudentViewholder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var students = emptyList<Student>()
    private val onClickListener: View.OnClickListener

    init {
        students = studentsCtor

        onClickListener = View.OnClickListener { v ->
            val item = v.tag as Student
            listener?.onListFragmentInteraction(item)
        }
    }
    inner class StudentViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentItemName: TextView = itemView.findViewById(R.id.student_name)
        val studentItemImage : ImageView = itemView.findViewById(R.id.student_image)
        val studentInitials: TextView = itemView.findViewById(R.id.student_initials)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewholder {
        val itemView = inflater.inflate(R.layout.student_view_item, parent, false)
        return StudentViewholder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewholder, position: Int) {
        val current = students[position]
        val firstName = current.firstName
        val lastName = current.lastName
        val initials = current.firstName?.take(1)?.toUpperCase()?.plus(current.lastName?.take(1)?.toUpperCase())
        holder.studentItemName.text = "$firstName $lastName"
        holder.studentInitials.text = initials
        holder.studentItemImage.setColorFilter(R.color.design_default_color_primary)

        with(holder.itemView) {
            tag = current
            setOnClickListener(onClickListener)
        }
    }

    override fun getItemCount() = students.size
}