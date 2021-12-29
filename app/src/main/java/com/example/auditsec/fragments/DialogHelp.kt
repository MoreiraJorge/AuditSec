package com.example.auditsec.fragments

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.auditsec.R

class DialogHelp : DialogFragment() {
    @SuppressLint("InflateParams")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater;
            val view = inflater.inflate(R.layout.help_dialog, null)
            builder.setView(view)

            val descriptionYes = view.findViewById<TextView>(R.id.tvYesDescription);
            val descriptionUN = view.findViewById<TextView>(R.id.tvUnofficialDescription);
            val descriptionAssigned = view.findViewById<TextView>(R.id.tvAssignedDescription);
            val descriptionNo = view.findViewById<TextView>(R.id.tvNoDescription);
            val descriptionReserved = view.findViewById<TextView>(R.id.tvReservedDescription);

            descriptionYes.text = resources.getString(R.string.descriptionYes)
            descriptionUN.text = resources.getString(R.string.descriptionUN)
            descriptionAssigned.text = resources.getString(R.string.descriptionAssigned)
            descriptionNo.text = resources.getString(R.string.descriptionNo)
            descriptionReserved.text = resources.getString(R.string.descriptionReserved)

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}