package com.example.auditsec.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.classes.ScannerItem
import com.example.auditsec.R
import java.util.ArrayList

class ScannerRecyclerAdapter()
    : RecyclerView.Adapter<ScannerRecyclerAdapter.ViewHolder>()
{
    private val mList = ArrayList<ScannerItem>(10)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_scanner_item, parent, false)
        return ViewHolder(itemView)
   }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.textView.text = "${item.portNumber} is ${item.portStatus}"
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = ItemView.findViewById(R.id.tvPortScanDetails);
    }

    fun addItem(item: ScannerItem) {
        mList.add(item)
        notifyItemInserted(itemCount - 1)
    }
}