package it.reti.percorsi.school.ui.ClassroomList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import it.reti.percorsi.school.R
import it.reti.percorsi.school.db.entities.Classroom

class ClassroomListAdapter internal constructor(
    context: Context,
    classrooms: List<Classroom>
) : RecyclerView.Adapter<ClassroomListAdapter.ClassroomViewholder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var classrooms = emptyList<Classroom>()

    inner class ClassroomViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val classroomItemView: TextView = itemView.findViewById(R.id.class_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassroomViewholder {
        val itemView = inflater.inflate(R.layout.list_classroom_fragment, parent, false)
        return ClassroomViewholder(itemView)
    }

    override fun onBindViewHolder(holder: ClassroomViewholder, position: Int) {
        val current = classrooms[position]
        holder.classroomItemView.text = current.name
    }

    override fun getItemCount() = classrooms.size
}