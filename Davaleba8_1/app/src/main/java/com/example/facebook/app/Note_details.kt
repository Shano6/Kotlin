package com.example.facebook.app

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.facebook.MainActivity
import com.example.facebook.R


class NoteDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        //inputs
        val idEdit = findViewById<EditText>(R.id.editId)
        val nameEdit = findViewById<EditText>(R.id.editName)
        val descriptionEdit = findViewById<EditText>(R.id.editDescription)
        val button = findViewById<Button>(R.id.addButtonId)

        //Id Parameter
        val b = intent.extras

        if(b!=null){
            val id = b.getString("id")
            idEdit.isEnabled = false
            nameEdit.isEnabled = false
            descriptionEdit.isEnabled = false
            button.text = "Edit"
            val preferences = getSharedPreferences("Notes", MODE_PRIVATE)
            val currentNote = preferences.getStringSet(id, null)
            idEdit.setText(currentNote!!.elementAt(0))
            nameEdit.setText(currentNote.elementAt(1))
            descriptionEdit.setText(currentNote.elementAt(2))
        } else{
            button.text = "Add"
        }

        button.setOnClickListener{
           if(button.text==="Edit"){
               nameEdit.isEnabled = true
               descriptionEdit.isEnabled = true
               button.text = "Save"
           } else{
               if(validInput(idEdit.text, nameEdit.text, descriptionEdit.text)){
                   val set : Set<String> = setOf(
                       idEdit.text.toString(),
                       nameEdit.text.toString(),
                       descriptionEdit.text.toString())
                   val preferences = getSharedPreferences("Notes", MODE_PRIVATE)
                   preferences.edit().putStringSet(idEdit.text.toString(), set).apply()
                   startActivity(Intent(this, MainActivity::class.java))
               } else{
                   Toast.makeText(this, "There are input Validation Errors", Toast.LENGTH_SHORT).show()
               }
           }
        }
    }
    private fun validInput(
        id: Editable?,
        name: Editable?,
        description: Editable?
    ): Boolean {
        if(id!==null && name!==null && description!==null){
            return id.isNotEmpty() &&
                    name.isNotEmpty() &&
                    description.isNotEmpty() &&
                    id.toString() !== name.toString() &&
                    id.toString() !== description.toString() &&
                    name.toString() !== description.toString()
            //რადგანაც setია ერთნაირები არ უნდა იყოს
        }
        return false
    }
}