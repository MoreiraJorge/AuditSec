package com.example.auditsec.classes

import androidx.fragment.app.FragmentActivity
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import java.net.*


class PortScan(private val _host: String,
               private val adapter: ScannerRecyclerAdapter,
               private val portsList: ArrayList<Int>,
               private val _activity: FragmentActivity?,
): Thread()
{
    private val host: String = _host;
    private val activity: FragmentActivity? = _activity;

    override fun run() {
        while (true) {
            sleep((0..300).random().toLong())
            if (portsList.size == 0) {
                return
            }
            val port = getNextPort()
            println("Thread # " + Thread.currentThread().id + " is doing port " + port);
            val portStatus = scanPort(port);
            activity?.runOnUiThread {
                adapter.addItem(portStatus)
            }
        }
    }

    private fun getNextPort(): Int {
        synchronized(portsList) {
            return portsList.removeFirst()
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
            ScannerItem("Timed Out", portNumber)
        }
    }
}