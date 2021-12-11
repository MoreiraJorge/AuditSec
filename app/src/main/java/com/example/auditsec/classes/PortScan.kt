package com.example.auditsec.classes

import com.example.auditsec.adapters.ScannerRecyclerAdapter
import java.net.Socket

class PortScan(private val ScannerAdapter: ScannerRecyclerAdapter, private val host: String, private val portNumber: Int) : Thread() {

    override fun run() {
        try {
            val sock = Socket(host, portNumber)
            if (sock.isConnected) {
                ScannerAdapter.addItem(ScannerItem("Opened", portNumber))
            } else {
                ScannerAdapter.addItem(ScannerItem("Closed", portNumber))
            }
        } catch (e: Exception) {
            ScannerAdapter.addItem(ScannerItem("N/A", portNumber))
        }
    }
}