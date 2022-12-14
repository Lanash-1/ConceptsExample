package com.example.conceptsexample.jobintentserviceexample

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.conceptsexample.R
import com.example.conceptsexample.workmanagerexample.WorkManagerActivity


class JobIntentServiceActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_intent_service)

        val enqueueBtn = findViewById<Button>(R.id.enqueueBtn)
        editText = findViewById(R.id.editTxt)

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, WorkManagerActivity::class.java)
            startActivity(intent)
        }

        enqueueBtn.setOnClickListener {
            val input: String = editText.getText().toString()

            val serviceIntent = Intent(this, ExampleJobIntentService::class.java)
            serviceIntent.putExtra("inputExtra", input)

            ExampleJobIntentService.enqueueWork(this, serviceIntent)
        }
    }
}