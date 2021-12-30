package com.example.auditsec.fragments

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.auditsec.R
import com.example.auditsec.activities.MainActivity
import com.example.auditsec.classes.PortUtils

class PortScanConfiguration : Fragment() {
    private lateinit var scanButton: Button
    private lateinit var mActivity: MainActivity

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        mActivity = activity as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_port_scan_configuration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        scanButton = view.findViewById(R.id.btScan)

        scanButton = view.findViewById(R.id.btScan)
        val etIpAddress: EditText = view.findViewById(R.id.etIpAddress)
        val etPorts: EditText = view.findViewById(R.id.etPorts)
        val etTimeout: EditText = view.findViewById(R.id.etTimeout)
        val etNumThreads: EditText = view.findViewById(R.id.etNumThreads)

        scanButton.setOnClickListener {
            val isValid = validateForm(etIpAddress, etPorts, etTimeout, etNumThreads)

            if(isValid) {
                val address = etIpAddress.text.toString()
                val ports = PortUtils.retrievePorts(etPorts.text.toString())

                var timeout: Int = when {
                    etTimeout.text.toString().toInt() < 0 -> {
                        1000
                    }
                    etTimeout.text.toString().toInt() > 60 -> {
                        60000
                    }
                    else -> {
                        etTimeout.text.toString().toInt() * 1000
                    }
                }

                var numThreads: Int = when {
                    etNumThreads.text.toString().toInt() < 0 -> {
                        1
                    }
                    etNumThreads.text.toString().toInt() > 16 -> {
                        16
                    }
                    else -> {
                        etNumThreads.text.toString().toInt()
                    }
                }

                mActivity.replacePortScan(address, ports, timeout, numThreads)
            }
        }
    }

    private fun validateForm(etIpAddress: EditText, etPorts: EditText, etTimeout: EditText, etNumThreads: EditText): Boolean {
        var isValid = true

        if( TextUtils.isEmpty(etIpAddress.text)){
            etIpAddress.error = "Host is required!"
            isValid = false
        }
        if( TextUtils.isEmpty(etPorts.text)){
            etPorts.error = "Ports is required!"
            isValid = false
        }
        if( TextUtils.isEmpty(etTimeout.text)){
            etTimeout.error = "Timeout is required!"
            isValid = false
        }
        if( TextUtils.isEmpty(etNumThreads.text)){
            etNumThreads.error = "Number of threads is required!"
            isValid = false
        }

        return isValid
    }
}