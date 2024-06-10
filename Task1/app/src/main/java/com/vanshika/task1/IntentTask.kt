package com.vanshika.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class IntentTask : AppCompatActivity() {
    var name : EditText?=null
    var college : EditText?=null
    var contact : EditText?=null
    var email : EditText?=null
    private var previousName = ""
    private var previousNumber = ""
    private var previousCollege = ""
    private var previousEmail = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_task)
        name = findViewById(R.id.name)
        college = findViewById(R.id.etCollege)
        contact = findViewById(R.id.contact)
        email = findViewById(R.id.etEmail)
        intent?.extras?.let {
            previousName = it.getString("name")?:""
            previousCollege = it.getString("college")?:""
            previousNumber = it.getString("phoneNumber")?:""
            previousEmail = it.getString("email")?:""
            println("previous key $previousName $previousCollege $previousNumber $previousEmail")
        }
        name?.setText(previousName)
        college?.setText(previousCollege)
        contact?.setText(previousNumber)
        email?.setText(previousEmail)
    }
}