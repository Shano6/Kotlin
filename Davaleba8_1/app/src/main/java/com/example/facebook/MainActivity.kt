package com.example.facebook

import RecyclerItemClickListener
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.facebook.app.NoteDetails
import com.example.facebook.app.User_RecycleViewAdapter
import com.example.facebook.app.dto.Note


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notes : ArrayList<Note> = arrayListOf()
        val preferences = getSharedPreferences("Notes", MODE_PRIVATE)

        preferences.all.forEach {
            var noteSet: Set<String> = it.value as Set<String>
            notes.add(Note(
                noteSet.elementAt(0),
                noteSet.elementAt(1),
                noteSet.elementAt(2)
            ))
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerID)
        val addButton = findViewById<Button>(R.id.addButtonId)
        val adapter = User_RecycleViewAdapter(this, notes)


        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.addOnItemTouchListener(
            RecyclerItemClickListener(this, recyclerView, object : RecyclerItemClickListener.OnItemClickListener{
                override fun onItemClick(view: View?, position: Int) {
                    val detailsActivity = Intent(this@MainActivity, NoteDetails::class.java)
                    detailsActivity.putExtra("id", notes[position].id)
                    startActivity(detailsActivity)
                }

                override fun onLongItemClick(view: View?, position: Int) {
                    // ვერ მოვასწარი :D
                }
            })
        )

        addButton.setOnClickListener{
            val detailsActivity = Intent(this@MainActivity, NoteDetails::class.java)
            startActivity(detailsActivity)
        }
    }
}