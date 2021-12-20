package com.example.auditsec.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import com.example.auditsec.R
import com.example.auditsec.classes.PortScan
import com.example.auditsec.classes.PortUtils
import com.google.android.material.textfield.TextInputEditText
import java.util.concurrent.Executors

class ScannerActivity : AppCompatActivity() {
    private lateinit var scanButton: Button;
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScannerRecyclerAdapter
    private val host: String = "grab.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_scanner)

        adapter = ScannerRecyclerAdapter()
        recyclerView = findViewById<RecyclerView>(R.id.rvScanResult)
        scanButton = findViewById(R.id.btScan)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        scanButton = findViewById<Button>(R.id.btScan)
        val tiIpAddress: EditText = findViewById<EditText>(R.id.tiIpAddress)
        val tiPorts: TextInputEditText = findViewById<TextInputEditText>(R.id.tiPorts)

        scanButton.setOnClickListener {
            val host = tiIpAddress.text.toString()
            val tiPortsText = tiPorts.text.toString()

            val ports = PortUtils.retrievePorts(tiPortsText)

            val commonlyUsedPorts: ArrayList<Int> = arrayListOf(22, 80, 443, 3306, 21, 25, 53,1720, 8080, 8988, 9999)
            scan(ports, adapter)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun scan(commonlyUsedPorts: ArrayList<Int>, adapter: ScannerRecyclerAdapter) {
        val executor = Executors.newFixedThreadPool(1)
        val worker = PortScan(host, adapter, commonlyUsedPorts, this@ScannerActivity)
        executor.execute(worker)
        println("Scanned main thread")
    }
}