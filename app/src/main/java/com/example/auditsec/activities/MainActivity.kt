package com.example.auditsec.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.auditsec.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MAIN_ACTIVITY", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MAIN_ACTIVITY", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN_ACTIVITY", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MAIN_ACTIVITY", "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MAIN_ACTIVITY", "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN_ACTIVITY", "onDestroy()")
    }
}