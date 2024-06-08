package com.vanshika.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var click : Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        click = findViewById(R.id.button)

        click?.setOnClickListener {
            Toast.makeText(this, "This is toast", Toast.LENGTH_LONG).show()
        }

    }
}
