package com.example.conceptsexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.example.conceptsexample.intentservicesexample.IntentServicesActivity


class MainActivity : AppCompatActivity() {

    lateinit var startBtn: Button
    lateinit var stopBtn: Button
    lateinit var text: TextView
    lateinit var switch: SwitchCompat
    lateinit var nextBtn: Button
    lateinit var progressBar: ProgressBar

    @Volatile
    private var stopThread: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn = findViewById(R.id.startBtn)
        stopBtn = findViewById(R.id.stopBtn)
        text = findViewById(R.id.text_view)
        switch = findViewById(R.id.toggle_switch)
        nextBtn = findViewById(R.id.nextBtn)
        progressBar = findViewById(R.id.progressBar)

        nextBtn.setOnClickListener {
            println("next")
            val intent = Intent(this, IntentServicesActivity::class.java)
            startActivity(intent)
        }


        startBtn.setOnClickListener {
            stopThread = false
            startProcess()
        }

        stopBtn.setOnClickListener {
            stopThread = true
            Log.d("ConceptExample", "Stopped the thread")
        }
    }

    private fun startProcess(){
        val handler = Handler(Looper.getMainLooper())
        progressBar.visibility = View.VISIBLE
        progressBar.max = 10
        Thread {

            for (i in 0..10) {
                if(stopThread){
                    handler.post{
                        progressBar.visibility = View.GONE
                    }
                    return@Thread
                }
                if (i == 5) {
                    handler.post { text.text = "50 percent completed" }
                }
                handler.post{
                    progressBar.progress = i
                }
                Thread.sleep(1000)
                Log.d("ConceptExample", "running in main thread: $i")
            }
        }.start()
    }
}




