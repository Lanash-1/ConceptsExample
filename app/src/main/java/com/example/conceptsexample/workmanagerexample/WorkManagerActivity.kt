package com.example.conceptsexample.workmanagerexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.*
import com.example.conceptsexample.R
import com.example.conceptsexample.practice.CustomExample
import java.util.concurrent.TimeUnit

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        val nextBtn = findViewById<Button>(R.id.nextBtn)
        nextBtn.setOnClickListener {
            val intent = Intent(this, CustomExample::class.java)
            startActivity(intent)
        }

        val workBtn = findViewById<Button>(R.id.worker_btn)


        workBtn.setOnClickListener {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val exampleWorkRequest: WorkRequest =
                PeriodicWorkRequestBuilder<ExampleWorker>(15, TimeUnit.MINUTES)
                    .setConstraints(constraints)
                    .build()

            WorkManager
                .getInstance(this)
                .enqueue(exampleWorkRequest)
        }

    }
}