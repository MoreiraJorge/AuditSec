package com.example.auditsec.fragments

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.R
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import com.example.auditsec.classes.PortScan
import com.example.auditsec.classes.PortUtils
import com.google.android.material.textfield.TextInputEditText
import java.util.concurrent.Executors

class PortScan : Fragment() {
    private lateinit var scanButton: Button;
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScannerRecyclerAdapter
    private val host: String = "grab.com"
    private val NUM_THREADS = 2

    //private var portList: ArrayList<ScannerItem>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_port_scan, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_port_scan, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)

                return false
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ScannerRecyclerAdapter()
        recyclerView = view.findViewById<RecyclerView>(R.id.rvScanResult)
        scanButton = view.findViewById(R.id.btScan)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        scanButton = view.findViewById<Button>(R.id.btScan)
        val tiIpAddress: EditText = view.findViewById<EditText>(R.id.tiIpAddress)
        val tiPorts: TextInputEditText = view.findViewById<TextInputEditText>(R.id.tiPorts)

        scanButton.setOnClickListener {
            val host = tiIpAddress.text.toString()
            val tiPortsText = tiPorts.text.toString()

            if(tiPortsText.trim().isNotEmpty()) {
                val ports = PortUtils.retrievePorts(tiPortsText)

                val commonlyUsedPorts: ArrayList<Int> = arrayListOf(22, 80, 443, 3306, 21, 25, 53,1720, 8080, 8988, 9999)
                scan(ports, adapter)
            }
        }
    }

    private fun scan(commonlyUsedPorts: ArrayList<Int>, adapter: ScannerRecyclerAdapter) {
        val executor = Executors.newFixedThreadPool(16)
        val worker = PortScan(host, adapter, commonlyUsedPorts, activity)
        for (i in 1..NUM_THREADS) {
            executor.execute(worker)
        }
    }
}