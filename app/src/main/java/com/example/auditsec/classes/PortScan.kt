package com.example.auditsec.classes

import com.example.auditsec.adapters.ScannerRecyclerAdapter
import java.net.Socket

class PortScan(){
    companion object{
        fun scan(ScannerAdapter: ScannerRecyclerAdapter, host: String, portNumber: Int): ScannerItem {
            try {
                val sock = Socket(host, portNumber)
                if (sock.isConnected) {
                    return ScannerItem("Opened", portNumber)
                } else {
                    return ScannerItem("Closed", portNumber)
                }
            } catch (e: Exception) {
                return ScannerItem("N/A", portNumber)
            }
        }
    }
}