package com.example.auditsec.classes

import android.widget.Filter
import com.example.auditsec.adapters.ScannerRecyclerAdapter
import kotlin.collections.ArrayList

class FilterPort(_filterList: ArrayList<ScannerItem>, private val adapterItem: ScannerRecyclerAdapter): Filter() {
    private val filterList: ArrayList<ScannerItem> = _filterList

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        var constraint1:CharSequence? = constraint
        val results = FilterResults()

        if(constraint1 != null && constraint1.isNotEmpty()) {
            val filteredPorts = ArrayList<ScannerItem>()

            for (i in filterList.indices) {
                if(filterList[i].portNumber.toString().contains(constraint1)) {
                    filteredPorts.add(filterList[i])
                }
            }

            results.count = filteredPorts.size
            results.values = filteredPorts
        } else {
            //Empty search
            results.count = filterList.size
            results.values = filterList
        }

        return results
    }

    override fun publishResults(constraint: CharSequence, results: FilterResults) {
        adapterItem.mList = results.values as ArrayList<ScannerItem>

        adapterItem.notifyDataSetChanged()
    }

}