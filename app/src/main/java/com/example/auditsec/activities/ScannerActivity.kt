package com.example.auditsec.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.auditsec.R
import java.util.concurrent.Executors

class ScannerActivity : AppCompatActivity() {

    private val numThreads: Int = 16
    private val host: String = "grab.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)
    }

    fun scanPorts(view: View) {
        val portScanResults = findViewById<EditText>(R.id.portScanResults)//findViewById<EditText>(R.id.portScanResults)
        val toast = Toast.makeText(applicationContext, "Port Scan Method", Toast.LENGTH_SHORT)
        toast.show()
        portScanResults.setText("Scan results for:\n$host\n============")

        val executor = Executors.newFixedThreadPool(numThreads)

        val commonlyUsedPorts = intArrayOf(22, 80, 443, 3306, 21, 25, 53,1720, 8080, 8988, 9999)
        for (port in commonlyUsedPorts) {
            val worker = PortScan(portScanResults, host, port)
            executor.execute(worker)
        }
        executor.shutdown()
    }


}