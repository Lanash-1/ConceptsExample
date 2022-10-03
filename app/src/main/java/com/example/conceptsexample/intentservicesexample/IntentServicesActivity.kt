package com.example.conceptsexample.intentservicesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.conceptsexample.R

class IntentServicesActivity : AppCompatActivity() {


    private lateinit var startServiceBtn: Button
    private lateinit var stopServiceBtn: Button
    private lateinit var serviceTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_services)

        startServiceBtn = findViewById(R.id.startServiceBtn)
        stopServiceBtn = findViewById(R.id.stopServiceBtn)
        serviceTextView = findViewById(R.id.intentService_textView)

        startServiceBtn.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                serviceTextView.text = "Service is running..."
            }
        }

        stopServiceBtn.setOnClickListener {
            MyIntentService.stopService()
            serviceTextView.text = "Service is stopping..."
        }

    }

}