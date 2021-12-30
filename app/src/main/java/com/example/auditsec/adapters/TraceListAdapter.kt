package com.example.auditsec.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.auditsec.R
import com.example.auditsec.classes.TracerouteContainer

class TraceListAdapter(private val context: Context,
                       private val traces: ArrayList<TracerouteContainer>) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return traces.size;
    }

    override fun getItem(position: Int): TracerouteContainer {
        return traces[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val holder: ViewHolder
        val rowView: View?

        if (convertView == null) {
            rowView = inflater.inflate(R.layout.item_list_trace, parent, false);
            val textViewNumber = rowView.findViewById<View>(R.id.textViewNumber)
            val textViewIp = rowView.findViewById<View>(R.id.textViewIp)
            val textViewTime = rowView.findViewById<View>(R.id.textViewTime)
            val imageViewStatusPing = rowView.findViewById<View>(R.id.imageViewStatusPing)

            // Set up the ViewHolder.
            holder = ViewHolder();
            holder.textViewNumber = textViewNumber as TextView
            holder.textViewIp = textViewIp as TextView
            holder.textViewTime = textViewTime as TextView
            holder.imageViewStatusPing = imageViewStatusPing as ImageView

            // Store the holder with the view.
            rowView.tag = holder
        } else {
            rowView = convertView
            holder = convertView.tag as ViewHolder
        }

        val currentTrace: TracerouteContainer = getItem(position)

//        if (position % 2 == 1) {
//            rowView?.setBackgroundResource(R.drawable.table_odd_lines)
//        } else {
//            rowView?.setBackgroundResource(R.drawable.table_pair_lines)
//        }
        if (currentTrace.isSuccessful) {
            holder.imageViewStatusPing!!.setImageResource(R.drawable.check)
        } else {
            holder.imageViewStatusPing!!.setImageResource(R.drawable.cross)
        }
        holder.textViewNumber.text = position.toString() + ""
        holder.textViewIp.text = currentTrace.hostname + " (" + currentTrace.ip + ")"
        holder.textViewTime.text = currentTrace.ms.toString() + "ms"
        return rowView
    }


    private class ViewHolder() {
        lateinit var textViewNumber: TextView
        lateinit var textViewIp: TextView
        lateinit var textViewTime: TextView
        lateinit var imageViewStatusPing: ImageView
    }
}