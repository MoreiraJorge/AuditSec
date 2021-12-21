package com.example.auditsec.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.auditsec.R
import com.example.auditsec.fragments.PortScan
import com.example.auditsec.fragments.TraceRoute
import com.google.android.material.bottomnavigation.BottomNavigationView
//https://www.youtube.com/watch?v=NJ_cbuSzAVw
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val portScan = PortScan()
        val traceRoute = TraceRoute()

        setCurrentFragment(portScan)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView
            .setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.port_scan -> setCurrentFragment(portScan)
                    R.id.traceroute -> setCurrentFragment(traceRoute)
                }
                true
            }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
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