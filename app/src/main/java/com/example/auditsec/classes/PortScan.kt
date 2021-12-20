package com.example.auditsec.classes

import android.R.attr
import android.annotation.SuppressLint
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import java.net.Socket
import android.R.attr.port
import java.net.InetSocketAddress


class PortScan(private val _host: String,
               private val adapter: ScannerRecyclerAdapter,
               private val portsList: ArrayList<Int>): Thread()
{
    private val host: String = _host;

    @SuppressLint("NotifyDataSetChanged")
    override fun run() {
        while (true) {
            println("Scanning...")
            if (portsList.size == 0) {
                return
            }
            val port = portsList.removeFirst()
            adapter.addItem(scanPort(port))
        }
    }

    private fun scanPort(portNumber: Int): ScannerItem {
        return try {
            val sock = Socket()
            sock.connect(InetSocketAddress(host, port), 1000)
            if (sock.isConnected) {
                sock.close()
                ScannerItem("Opened", portNumber)
            } else {
                sock.close()
                ScannerItem("Closed", portNumber)
            }
        } catch (e: Exception) {
            ScannerItem("N/A", portNumber)
        }
    }
}