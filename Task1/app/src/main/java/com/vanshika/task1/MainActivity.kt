package com.vanshika.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var click : Button?=null
    var contact: EditText?=null
    private var rbYes : RadioButton?=null
    private var rbNo : RadioButton?=null
    var studyField : EditText?=null
    var name : EditText?=null
    var etCollege : EditText?=null
    var etEmail : EditText?=null
    private var rgButton : RadioGroup?=null
    var btnNext : Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        click = findViewById(R.id.button)
        contact = findViewById(R.id.contact)
        rbYes = findViewById(R.id.rbYes)
        rbNo = findViewById(R.id.rbNo)
        studyField = findViewById(R.id.studyField)
        name = findViewById(R.id.name)
        etCollege = findViewById(R.id.etCollege)
        etEmail = findViewById(R.id.etEmail)
        rgButton = findViewById(R.id.rgButton)

        click?.setOnClickListener {
            if(name?.text.toString().trim().isNullOrEmpty()){
                name?.error=resources.getString(R.string.enter_your_name)
            }
            else if(etCollege?.text.toString().trim().isNullOrEmpty()){
                etCollege?.error=resources.getString(R.string.enter_your_college)
            }
            else if(contact?.text.toString().trim().isNullOrEmpty()){
                contact?.error=resources.getString(R.string.enter_your_number)
            }
            else if(contact?.text.toString().trim().length<10) {
                contact?.error = resources.getString(R.string.enter_a_valid_number)
            }
//            else if(contact?.text.toString().trim().rangeTo(6){
//                when(contact[0]){
//                    "0","1","2","3","4","5"->contact?.error = "Start the number with (6-9)"
//                    else->print("valid")
//                }
//            }
            else if(etEmail?.text.toString().trim().isNullOrEmpty()){
                etEmail?.error=resources.getString(R.string.enter_your_email)
            }
            else if( rbYes?.isChecked == true && studyField?.text.toString().trim().isNullOrEmpty()){
            studyField?.error=resources.getString(R.string.fill_this)
            }
            else if(rgButton?.checkedRadioButtonId == -1){
                Toast.makeText(this,"Select One",Toast.LENGTH_LONG).show()
            }
            else{
                Toast.makeText(this,"Successfully submitted",Toast.LENGTH_LONG).show()
                val intent = Intent(this,IntentTask::class.java)
                intent.putExtra("name",name?.text.toString().trim())
                intent.putExtra("college",etCollege?.text.toString().trim())
                intent.putExtra("phoneNumber",contact?.text.toString().trim())
                intent.putExtra("email",etEmail?.text.toString().trim())
                startActivity(intent)
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
    }
}