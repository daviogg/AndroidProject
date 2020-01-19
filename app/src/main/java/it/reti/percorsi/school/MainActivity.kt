package it.reti.percorsi.school

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.reti.percorsi.school.ui.ClassroomList.ClassroomListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       /* val recyclerView = findViewById<RecyclerView>(R.id.fragment_classroom_list_recycler)
        val adapter =
            ClassroomListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)*/
    }
}
