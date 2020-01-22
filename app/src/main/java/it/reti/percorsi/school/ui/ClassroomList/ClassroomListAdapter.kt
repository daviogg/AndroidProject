package it.reti.percorsi.school.ui.ClassroomList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.reti.percorsi.school.R
import it.reti.percorsi.school.db.entities.Classroom

class ClassroomListAdapter internal constructor(
    context: Context,
    classroomsCtor: List<Classroom>
) : RecyclerView.Adapter<ClassroomListAdapter.ClassroomViewholder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var classrooms = emptyList<Classroom>()

    init {
        classrooms = classroomsCtor
    }
        inner class ClassroomViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val classroomItemName: TextView = itemView.findViewById(R.id.class_name)
            val classroomItemNumberOfStudents: TextView = itemView.findViewById(R.id.number_of_students)
            val classroomItemImage :ImageView  = itemView.findViewById(R.id.imageView2)
            val classroomItemDescription: TextView = itemView.findViewById(R.id.class_description)

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassroomViewholder {
        val itemView = inflater.inflate(R.layout.classroom_view_item, parent, false)
        return ClassroomViewholder(itemView)
    }

    override fun onBindViewHolder(holder: ClassroomViewholder, position: Int) {
        val current = classrooms[position]
        holder.classroomItemName.text = current.name
        holder.classroomItemNumberOfStudents.text = current.studentIds.size.toString()
        holder.classroomItemDescription.text = current.section
    }

    override fun getItemCount() = classrooms.size
}