package com.example.auditsec.fragments

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.auditsec.R
import com.example.auditsec.activities.MainActivity
import com.google.android.material.textfield.TextInputEditText

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

        scanButton = view.findViewById<Button>(R.id.btScan)
        val tiIpAddress: EditText = view.findViewById<EditText>(R.id.tiIpAddress)
        val tiPorts: TextInputEditText = view.findViewById<TextInputEditText>(R.id.tiPorts)

        scanButton.setOnClickListener {
            mActivity.ReplacePortScan(tiIpAddress.text.toString(), tiPorts.text.toString())
        }
    }
}