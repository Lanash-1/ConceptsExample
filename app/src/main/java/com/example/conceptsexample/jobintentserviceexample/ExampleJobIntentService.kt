package com.example.conceptsexample.jobintentserviceexample

import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import androidx.core.app.JobIntentService


class ExampleJobIntentService: JobIntentService() {
    override fun onHandleWork(intent: Intent) {
        Log.d(TAG, "onHandleWork")

        val input = intent.getStringExtra("inputExtra")

        for (i in 0..9) {
            Log.d(TAG, "$input - $i")
            if (isStopped) return
            SystemClock.sleep(1000)
        }
    }

    override fun onCreate() {
        Log.d(TAG, "On Create")
        super.onCreate()
    }

    override fun onDestroy() {
        Log.d(TAG, "ON Destroy")
        super.onDestroy()
    }

    override fun onStopCurrentWork(): Boolean {
        Log.d(TAG, "ON Stop current work")
        return super.onStopCurrentWork()
    }

    companion object{
        fun enqueueWork(context: Context, work: Intent) {
            enqueueWork(context, ExampleJobIntentService::class.java, 1, work)
        }
        private const val TAG = "ExampleJobIntentService"
    }
}
