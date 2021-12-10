package com.example.auditsec.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.Classes.ScannerItem
import com.example.auditsec.R

class ScannerRecyclerAdapter(private val mList: List<ScannerItem>)
    : RecyclerView.Adapter<ScannerRecyclerAdapter.ViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_scanner_item, parent, false)
        return ViewHolder(itemView)
   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.textView.setText(item.portStatus)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = ItemView.findViewById(R.id.tvPortScanDetails)
    }
}