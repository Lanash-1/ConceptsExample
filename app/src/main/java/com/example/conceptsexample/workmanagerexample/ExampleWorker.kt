package com.example.conceptsexample.workmanagerexample

import android.content.Context
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import androidx.work.Worker
import androidx.work.WorkerParameters

class ExampleWorker(context: Context, workerParams: WorkerParameters) : Worker(context,
    workerParams
) {


    override fun doWork(): Result {
        for(i in 0..5){
            Log.d(TAG, "Running worker - $i")
            SystemClock.sleep(1000)
        }
        Log.d(TAG, "Work finished")
        return Result.success()
    }

    companion object{
        private const val TAG = "ExampleWorker"
    }
}