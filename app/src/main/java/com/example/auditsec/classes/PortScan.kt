package com.example.auditsec.classes

import android.annotation.SuppressLint
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import java.net.*
import com.example.auditsec.activities.ScannerActivity


class PortScan(private val _host: String,
               private val adapter: ScannerRecyclerAdapter,
               private val portsList: ArrayList<Int>,
               private val _activity: ScannerActivity
): Thread()
{
    private val host: String = _host;
    private val activity: ScannerActivity = _activity;

    @SuppressLint("NotifyDataSetChanged")
    override fun run() {
        while (true) {
            println("Scanning...")
            if (portsList.size == 0) {
                return
            }
            val port = portsList.removeFirst()
            val myvar = scanPort(port);
            activity.runOnUiThread {
                adapter.addItem(myvar)
            }
        }
    }

    private fun scanPort(portNumber: Int): ScannerItem {
        return try {
            val sock = Socket()
            sock.connect(InetSocketAddress(host, portNumber), 3000)
            if (sock.isConnected) {
                sock.close()
                ScannerItem("Opened", portNumber)
            } else {
                ScannerItem("Closed", portNumber)
            }
        } catch (e: Exception) {
            println(e.message)
            ScannerItem("N/A", portNumber)
        }
    }
}