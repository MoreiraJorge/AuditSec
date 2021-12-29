package com.example.auditsec.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.R
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import com.example.auditsec.classes.PortScan
import com.example.auditsec.classes.PortUtils
import com.example.auditsec.utils.Sort
import com.google.android.material.textfield.TextInputEditText
import java.util.concurrent.Executors

class PortScan : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ScannerRecyclerAdapter
    private lateinit var tiIpAddress: String
    private lateinit var tiPorts: String
    private val NUM_THREADS = 10

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true);
        val bundle = arguments
        if (bundle != null) {
            tiIpAddress = bundle.getString("tiIpAddress") as String
            tiPorts = bundle.getString("tiPorts") as String
        }
        return inflater.inflate(R.layout.fragment_port_scan, container, false)
    }

    override fun onStart() {
        scan()
        super.onStart()
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
        val id = item.itemId

        if (id == R.id.action_sort) {
            sortDialog()
        } else if(id == R.id.help){
            println("Clicked!")
            helpDialog()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ScannerRecyclerAdapter()
        recyclerView = view.findViewById<RecyclerView>(R.id.rvScanResult)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter

        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL));

    }

    private fun scan() {
        val ports = PortUtils.retrievePorts(tiPorts)
        val executor = Executors.newFixedThreadPool(16)
        val worker = PortScan(tiIpAddress, adapter, ports, activity)
        for (i in 1..NUM_THREADS) {
            executor.execute(worker)
        }
    }

    private fun sortDialog() {
        val options = arrayOf("Ascending", "Descending")

        val dialog = AlertDialog.Builder(this.context)
        dialog.setTitle("Sort")
            .setItems(options) { dialogInterface, i ->
                if (i == 0) {
                    dialogInterface.dismiss()
                    adapter.sortList(Sort.ASC)
                } else if (i == 1) {
                    dialogInterface.dismiss()
                    adapter.sortList(Sort.DESC)
                }
            }.show()
    }

    private fun helpDialog() {
        val newFragment = DialogHelp()
        newFragment.show(parentFragmentManager, "Help Ports")
    }
}