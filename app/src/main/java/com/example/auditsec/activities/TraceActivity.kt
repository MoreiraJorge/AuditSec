package com.example.auditsec.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.auditsec.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.auditsec.classes.TracerouteContainer
import com.example.auditsec.classes.TracerouteWithPing
import java.util.ArrayList


/**
 * The main activity
 *
 * @author Olivier Goutay
 */
class TraceActivity : AppCompatActivity() {
    private var buttonLaunch: Button? = null
    private var editTextPing: EditText? = null
    private var progressBarPing: ProgressBar? = null
    private var listViewTraceroute: ListView? = null
    private var traceListAdapter: TraceListAdapter? = null
    private var tracerouteWithPing: TracerouteWithPing? = null
    private val maxTtl = 40
    private var traces: MutableList<TracerouteContainer>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_trace)

        tracerouteWithPing = TracerouteWithPing(this)
        traces = ArrayList<TracerouteContainer>()
        buttonLaunch = findViewById<View>(R.id.buttonLaunch) as Button
        editTextPing = findViewById<View>(R.id.editTextPing) as EditText
        listViewTraceroute = findViewById<View>(R.id.listViewTraceroute) as ListView
        progressBarPing = findViewById<View>(R.id.progressBarPing) as ProgressBar

        initView()
    }

    private fun initView() {
        buttonLaunch!!.setOnClickListener {
            if (editTextPing!!.text.isEmpty()) {
                Toast.makeText(this@TraceActivity, "No text", Toast.LENGTH_SHORT)
                    .show()
            } else {
                traces!!.clear()
                traceListAdapter!!.notifyDataSetChanged()
                startProgressBar()
                hideSoftwareKeyboard(editTextPing)
                tracerouteWithPing?.executeTraceroute(editTextPing!!.text.toString(), maxTtl)
            }
        }
        traceListAdapter = TraceListAdapter(applicationContext)
        listViewTraceroute!!.adapter = traceListAdapter
    }

    /**
     * Allows to refresh the listview of traces
     *
     * @param traces
     * The list of traces to refresh
     */
    fun refreshList(trace: TracerouteContainer) {
        val fTrace: TracerouteContainer = trace
        runOnUiThread {
            traces!!.add(fTrace)
            traceListAdapter!!.notifyDataSetChanged()
        }
    }

    /**
     * The adapter of the listview (build the views)
     */
    inner class TraceListAdapter(private val context: Context) : BaseAdapter() {
        override fun getCount(): Int {
            return traces!!.size
        }

        override fun getItem(position: Int): TracerouteContainer {
            return traces!![position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
            var convertView = convertView
            val holder: ViewHolder

            // first init
            if (convertView == null) {
                val vi = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
                convertView = vi.inflate(R.layout.item_list_trace, null)
                val textViewNumber = convertView.findViewById<View>(R.id.textViewNumber) as TextView
                val textViewIp = convertView.findViewById<View>(R.id.textViewIp) as TextView
                val textViewTime = convertView.findViewById<View>(R.id.textViewTime) as TextView
                val imageViewStatusPing =
                    convertView.findViewById<View>(R.id.imageViewStatusPing) as ImageView

                // Set up the ViewHolder.
                holder = ViewHolder()
                holder.textViewNumber = textViewNumber
                holder.textViewIp = textViewIp
                holder.textViewTime = textViewTime
                holder.imageViewStatusPing = imageViewStatusPing

                // Store the holder with the view.
                convertView.tag = holder
            } else {
                holder = convertView.tag as ViewHolder
            }
            val currentTrace: TracerouteContainer = getItem(position)
            if (position % 2 == 1) {
                convertView.setBackgroundResource(R.drawable.table_odd_lines)
            } else {
                convertView.setBackgroundResource(R.drawable.table_pair_lines)
            }
            if (currentTrace.isSuccessful) {
                holder.imageViewStatusPing!!.setImageResource(R.drawable.check)
            } else {
                holder.imageViewStatusPing!!.setImageResource(R.drawable.cross)
            }
            holder.textViewNumber!!.text = position.toString() + ""
            holder.textViewIp?.setText(currentTrace.hostname + " (" + currentTrace.ip + ")")
            holder.textViewTime?.setText(currentTrace.ms.toString() + "ms")
            return convertView
        }

        // ViewHolder pattern
        internal inner class ViewHolder {
            var textViewNumber: TextView? = null
            var textViewIp: TextView? = null
            var textViewTime: TextView? = null
            var imageViewStatusPing: ImageView? = null
        }
    }

    /**
     * Hides the keyboard
     *
     * @param currentEditText
     * The current selected edittext
     */
    fun hideSoftwareKeyboard(currentEditText: EditText?) {
        val imm = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive) {
            imm.hideSoftInputFromWindow(
                currentEditText!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    fun startProgressBar() {
        progressBarPing!!.visibility = View.VISIBLE
    }

    fun stopProgressBar() {
        progressBarPing!!.visibility = View.GONE
    }

    companion object {
        const val tag = "TraceroutePing"
        const val INTENT_TRACE = "INTENT_TRACE"
    }
}