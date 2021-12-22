package com.example.auditsec.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.auditsec.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scannerActivity(view: View) {
        val intent = Intent(this, ScannerActivity::class.java)
        startActivity(intent)
    }

    fun traceRouteActivity(view: View) {
        val intent = Intent(this, TraceActivity::class.java)
        startActivity(intent)
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