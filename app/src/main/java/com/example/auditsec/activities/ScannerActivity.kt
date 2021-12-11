package com.example.auditsec.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import com.example.auditsec.R
import com.example.auditsec.classes.PortScan
import com.example.auditsec.classes.ScannerItem
import java.util.concurrent.Executors

class ScannerActivity : AppCompatActivity() {

    private val numThreads: Int = 16
    private val host: String = "grab.com"
    private lateinit var scanButton: Button;
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScannerRecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)

        recyclerView = findViewById<RecyclerView>(R.id.rvScanResult)
        scanButton = findViewById(R.id.btScan)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ScannerRecyclerAdapter();
        recyclerView.adapter = adapter

        scanButton.setOnClickListener {
            println("HERE!")
            val executor = Executors.newFixedThreadPool(numThreads)
            val commonlyUsedPorts = intArrayOf(22, 80, 443, 3306, 21, 25, 53,1720, 8080, 8988, 9999)
            for (port in commonlyUsedPorts) {
                val worker = PortScan(adapter ,host, port)
                executor.execute(worker)
            }
            executor.shutdown()
        }

    }
}