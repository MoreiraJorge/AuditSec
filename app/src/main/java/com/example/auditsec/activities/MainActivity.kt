package com.example.auditsec.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.auditsec.R
import com.example.auditsec.fragments.PortScan
import com.example.auditsec.fragments.PortScanConfiguration
import com.example.auditsec.fragments.TraceRoute
import com.google.android.material.bottomnavigation.BottomNavigationView




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val portScan = PortScanConfiguration()
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

    fun ReplacePortScan(tiIpAddress: String, tiPorts: String) {
            val newFragment = PortScan()
            val bundle = Bundle()
            bundle.putString("tiIpAddress", tiIpAddress)
            bundle.putString("tiPorts", tiPorts)
            newFragment.arguments = bundle
            supportFragmentManager.beginTransaction()
                .replace(R.id.flFragment, newFragment)
                .addToBackStack(null)
                .commit()
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