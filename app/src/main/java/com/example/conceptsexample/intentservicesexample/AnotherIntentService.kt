package com.example.conceptsexample.intentservicesexample

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.lang.Exception

class AnotherIntentService: IntentService("AnotherIntentService") {

    init {
        instance = this
    }

    companion object {
        private var instance: AnotherIntentService? = null
        var isRunning = false

        fun stopService(){
            if(instance != null){
                Log.d("AnotherIntentService", "Another Service is stopping...")
                isRunning = false
                instance!!.stopSelf()
            }

        }
    }

    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while(isRunning){
                Log.d("AnotherIntentService", "Another Service is running")
                Thread.sleep(1000)
            }
        }catch (error: Exception){
            Thread.currentThread().interrupt()
        }
    }
}