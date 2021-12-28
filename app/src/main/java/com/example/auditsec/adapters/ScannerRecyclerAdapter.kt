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
import android.graphics.PorterDuff
import com.example.auditsec.classes.PORT_DETAILS
import com.example.auditsec.classes.Protocol
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class ScannerRecyclerAdapter() : RecyclerView.Adapter<ScannerRecyclerAdapter.ViewHolder>(),
    Filterable {
    var mList = ArrayList<ScannerItem>(30)
    private var filter: FilterPort? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_port_status_card, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        val portDetail = PORT_DETAILS.get(item.portNumber.toString())
        var portDescription = "No possible running services known"
        var protocols = null

        if(portDetail is JsonObject) {
            protocols = retrieveProtocolsForPort(portDetail)
            portDescription = portDetail.get("description").asString
        } else if(portDetail is JsonArray) {
            portDescription = "There are multiple possible services running on this port"
        }

        holder.tvPortScanned.text = "Port ${item.portNumber}"
        holder.tvPortStatus.text = "${item.portStatus}"
        holder.tvPortDescription.text = portDescription
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
        val tvPortScanned: TextView = ItemView.findViewById(R.id.tvPortScanned);
        val tvPortStatus: TextView = ItemView.findViewById(R.id.tvPortStatus);
        val tvPortDescription: TextView = ItemView.findViewById(R.id.tvPortDescription);
    }

    fun addItem(item: ScannerItem) {
        mList.add(item)
        notifyItemInserted(mList.size - 1)
    }

    private fun retrieveProtocolsForPort(portDetails: JsonObject): ArrayList<Protocol> {
        var existingProtocols: ArrayList<Protocol> = ArrayList()

        if(portDetails.get("tcp").asString.trim().isNotEmpty())
            existingProtocols.add(Protocol("TCP", portDetails.get("tcp").asString.trim()))
        if(portDetails.get("udp").asString.trim().isNotEmpty())
            existingProtocols.add(Protocol("UDP", portDetails.get("udp").asString.trim()))
        if(portDetails.get("sctp").asString.trim().isNotEmpty())
            existingProtocols.add(Protocol("SCTP", portDetails.get("sctp").asString.trim()))
        if(portDetails.get("dccp").asString.trim().isNotEmpty())
            existingProtocols.add(Protocol("DCCP", portDetails.get("dccp").asString.trim()))

        return existingProtocols
    }

    private fun addProtocolChips(protocols: ArrayList<Protocol>) {

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