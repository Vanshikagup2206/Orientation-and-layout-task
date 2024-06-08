package com.vanshika.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var click : Button?=null
    var contact: EditText?=null
    private var rbYes : RadioButton?=null
    var rbNo : RadioButton?=null
    var studyField : EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        click = findViewById(R.id.button)
        contact = findViewById(R.id.contact)
        rbYes = findViewById(R.id.rbYes)
        rbNo = findViewById(R.id.rbNo)
        studyField = findViewById(R.id.studyField)


        click?.setOnClickListener {
            Toast.makeText(this, "Successfully submitted", Toast.LENGTH_LONG).show()
        }
        click?.setOnClickListener {
            if(contact?.text.toString().trim().isNullOrEmpty()){
                contact?.error="Enter your number"
            }
            else if(contact?.text.toString().trim().length<10){
                contact?.error="Enter a valid number"
            }
        }
        rbYes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                studyField?.visibility = View.VISIBLE
            }
            else{
                studyField?.visibility = View.GONE
            }
        }
        rbYes?.setOnClickListener {
            if(studyField?.text.toString().trim().isNullOrEmpty()){
                studyField?.error="Fill this"
            }
        }

    }
}
