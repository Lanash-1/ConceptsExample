package com.example.conceptsexample.jobschedulerexample

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.conceptsexample.R
import com.example.conceptsexample.jobintentserviceexample.JobIntentServiceActivity

class JobSchedulerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_scheduler)

        val startScheduleBtn = findViewById<Button>(R.id.schedule_job)
        val stopScheduleBtn = findViewById<Button>(R.id.stop_job)
        val nextBtn = findViewById<Button>(R.id.nextBtn)

        nextBtn.setOnClickListener {
            val intent = Intent(this, JobIntentServiceActivity::class.java)
            startActivity(intent)
        }

        startScheduleBtn.setOnClickListener {
            val componentName = ComponentName(this, ExampleJobService::class.java)
            val jobInfo = JobInfo.Builder(1, componentName)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000)
                .build()

            val scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val resultCode: Int = scheduler.schedule(jobInfo)
            if(resultCode == JobScheduler.RESULT_SUCCESS){
                Log.d(TAG, "Job Scheduled")
            }else{
                Log.d(TAG, "Job Schedule failed")
            }
        }

        stopScheduleBtn.setOnClickListener {
            val scheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            scheduler.cancel(1)
            Log.d(TAG, "job cancelled")
        }
    }

    companion object{
        private const val TAG = "MainActivity"
    }
}