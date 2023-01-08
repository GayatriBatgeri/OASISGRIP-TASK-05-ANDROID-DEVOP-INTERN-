package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    var pauseAt:Long=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnstart = findViewById<Button>(R.id.btnstart)
        val btnstop = findViewById<Button>(R.id.btnstop)
        val btnreset = findViewById<Button>(R.id.btnreset)
        val stopwatch = findViewById<Chronometer>(R.id.stopwatch)
        btnstart.setOnClickListener(){
            stopwatch.base= SystemClock.elapsedRealtime()-pauseAt
            stopwatch.start()
        }
        btnstop.setOnClickListener(){
            pauseAt= SystemClock.elapsedRealtime()-stopwatch.base
            stopwatch.stop()
        }
        btnreset.setOnClickListener(){
            stopwatch.base= SystemClock.elapsedRealtime()
            stopwatch.stop()
        }

    }
}