package com.example.auditsec.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import com.example.auditsec.R
import com.example.auditsec.classes.PortScan
import com.example.auditsec.classes.ScannerItem

class ScannerActivity : AppCompatActivity() {

    private val host: String = "grab.com"
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
            val commonlyUsedPorts = intArrayOf(22, 80, 443, 3306, 21, 25, 53,1720, 8080, 8988, 9999)
            var list = ArrayList<ScannerItem>()
            for (port in commonlyUsedPorts) {
                list.add(PortScan.scan(adapter ,host, port))
            }
            adapter.setList(list)
            adapter.notifyDataSetChanged()
        }
    }
}