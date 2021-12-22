package com.example.auditsec.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.auditsec.classes.ScannerItem
import com.example.auditsec.R
import com.example.auditsec.classes.FilterPort
import com.example.auditsec.utils.Sort
import kotlin.Comparator
import kotlin.collections.ArrayList
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable

import androidx.core.content.ContextCompat

import android.graphics.drawable.ShapeDrawable


class ScannerRecyclerAdapter() : RecyclerView.Adapter<ScannerRecyclerAdapter.ViewHolder>(),
    Filterable {
    var mList = ArrayList<ScannerItem>(30)
    private var filter: FilterPort? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_scanner_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.textView.text = "${item.portNumber} is ${item.portStatus}"
        val imageView = holder.itemView.findViewById<ImageView>(R.id.spStatus)
        val drawable = imageView.drawable.mutate()

        when (item.portStatus) {
            "Opened" -> {
                drawable.setColorFilter(
                    holder.itemView.resources.getColor(R.color.open_port),
                    PorterDuff.Mode.SRC
                );
            }
            "Closed" -> {
                drawable.setColorFilter(
                    holder.itemView.resources.getColor(R.color.closed_port),
                    PorterDuff.Mode.SRC
                );
            }
            "Filtered" -> {
                drawable.setColorFilter(
                    holder.itemView.resources.getColor(R.color.filtered_port),
                    PorterDuff.Mode.SRC
                );
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = ItemView.findViewById(R.id.tvPortScanDetails);
    }

    fun addItem(item: ScannerItem) {
        mList.add(item)
        notifyItemInserted(mList.size - 1)
    }

    override fun getFilter(): Filter {
        if (filter == null) {
            filter = FilterPort(mList, this)
        }

        return filter as FilterPort
    }

    fun sortList(sortDirection: Sort, updateList: Boolean = true) {
        if (sortDirection == Sort.ASC) {
            mList.sortWith(Comparator { lhs, rhs -> lhs.portNumber.compareTo(rhs.portNumber) })
        } else if (sortDirection == Sort.DESC) {
            mList.sortWith(Comparator { lhs, rhs -> rhs.portNumber.compareTo(lhs.portNumber) })
        }

        if (updateList != null && updateList) notifyDataSetChanged()
    }
}