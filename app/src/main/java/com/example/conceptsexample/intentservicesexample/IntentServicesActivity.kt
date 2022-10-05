package com.example.conceptsexample.intentservicesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.conceptsexample.R
import com.example.conceptsexample.jobschedulerexample.JobSchedulerActivity

class IntentServicesActivity : AppCompatActivity() {

    private lateinit var startServiceBtn: Button
    private lateinit var stopServiceBtn: Button
    private lateinit var serviceTextView: TextView
    private lateinit var anotherStart: Button
    private lateinit var anotherStop: Button
    private lateinit var nextBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_services)

        startServiceBtn = findViewById(R.id.startServiceBtn)
        stopServiceBtn = findViewById(R.id.stopServiceBtn)
        serviceTextView = findViewById(R.id.intentService_textView)
        anotherStart = findViewById(R.id.another_startServiceBtn)
        anotherStop = findViewById(R.id.another_stopServiceBtn)
        nextBtn = findViewById(R.id.nextBtn)

        nextBtn.setOnClickListener {
            val intent = Intent(this, JobSchedulerActivity::class.java)
            startActivity(intent)
        }

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

        anotherStart.setOnClickListener {
            Intent(this, AnotherIntentService::class.java).also {
                startService(it)
                serviceTextView.text = "Starting another service ..."
            }
        }

        anotherStop.setOnClickListener {
            AnotherIntentService.stopService()
            serviceTextView.text = "Another Service is stopping..."

        }

    }

}