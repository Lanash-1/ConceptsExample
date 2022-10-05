package com.example.conceptsexample.jobintentserviceexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.conceptsexample.R

class JobIntentServiceActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_intent_service)

        val enqueueBtn = findViewById<Button>(R.id.enqueueBtn)
        editText = findViewById(R.id.editTxt)

        enqueueBtn.setOnClickListener {

        }
    }
}