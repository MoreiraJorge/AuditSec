package com.example.auditsec.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.classes.ScannerItem
import com.example.auditsec.R
import com.example.auditsec.classes.FilterPort
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class ScannerRecyclerAdapter()
    : RecyclerView.Adapter<ScannerRecyclerAdapter.ViewHolder>(), Filterable
{
    var mList = ArrayList<ScannerItem>(30)
    private var filterList: ArrayList<ScannerItem> = ArrayList<ScannerItem>(30)
    private var filter: FilterPort? = null

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
        mList.sortWith(Comparator { lhs, rhs -> lhs.portNumber.compareTo(rhs.portNumber) })
        notifyItemInserted(mList.size-1)
    }

    override fun getFilter(): Filter {
        if(filter == null) {
            filter = FilterPort(mList, this)
        }

        return filter as FilterPort
    }
}