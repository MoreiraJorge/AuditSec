package com.example.auditsec.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import com.example.auditsec.R
import com.example.auditsec.classes.PortScan
import com.example.auditsec.classes.ScannerItem
import java.util.concurrent.Executors

class ScannerActivity : AppCompatActivity() {

    private val host: String = "tpas-desafios.alunos.dcc.fc.up.pt"
    private lateinit var scanButton: Button;
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScannerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)

        recyclerView = findViewById(R.id.rvScanResult)
        scanButton = findViewById(R.id.btScan)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ScannerRecyclerAdapter();
        recyclerView.adapter = adapter

        scanButton.setOnClickListener {
            val commonlyUsedPorts: ArrayList<Int> = arrayListOf(22, 80, 443, 3306, 21, 25, 53,1720, 8080, 8988, 9999)
            scan(commonlyUsedPorts, adapter)
            adapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun scan(commonlyUsedPorts: ArrayList<Int>, adapter: ScannerRecyclerAdapter) {
        val executor = Executors.newFixedThreadPool(1)
        val worker = PortScan(host, adapter, commonlyUsedPorts)
        executor.execute(worker)
        println("Scanned main thread")
    }
}