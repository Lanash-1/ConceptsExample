package com.example.conceptsexample.jobschedulerexample

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class ExampleJobService: JobService() {

    override fun onStartJob(p0: JobParameters?): Boolean {
        jobCancelled = false
        Log.d(TAG, "Job Started")
        backgroundJob(p0)
        return true
    }

    private fun backgroundJob(p0: JobParameters?) {
        Thread {
            for(i in 0..10){
                Log.d(TAG, "RUN: $i")
                if(jobCancelled){
                    return@Thread
                }
                Thread.sleep(1000)
            }
            Log.d(TAG, "Job finished")
            jobFinished(p0, false)
        }.start()
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d(TAG, "Job cancelled before completion")
        jobCancelled = true
        return true
    }

    companion object {
        private const val TAG = "ExampleJobService"
        private var jobCancelled: Boolean = false
    }
}