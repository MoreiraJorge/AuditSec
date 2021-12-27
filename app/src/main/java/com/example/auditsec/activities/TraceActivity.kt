package com.example.auditsec.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.auditsec.R
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.auditsec.adapters.TraceListAdapter
import com.example.auditsec.classes.TracerouteContainer
import com.example.auditsec.classes.TracerouteWithPing


/**
 * The main activity
 *
 * @author Olivier Goutay
 */
class TraceActivity : AppCompatActivity() {
    private lateinit var buttonLaunch: Button;
    private lateinit var editTextPing: EditText;
    private lateinit var progressBarPing: ProgressBar;
    private lateinit var listViewTraceroute: ListView
    private lateinit var traceListAdapter: TraceListAdapter
    private lateinit var tracerouteWithPing: TracerouteWithPing;
    private lateinit var traces: MutableList<TracerouteContainer>;

    private val maxTtl = 40

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_trace)

        tracerouteWithPing = TracerouteWithPing(this)
        traces = ArrayList()
        buttonLaunch = findViewById(R.id.buttonLaunch)
        editTextPing = findViewById(R.id.editTextPing)
        listViewTraceroute = findViewById(R.id.listViewTraceroute)
        progressBarPing = findViewById(R.id.progressBarPing)

        initView()
    }

    private fun initView() {
        traceListAdapter = TraceListAdapter(applicationContext,
            traces as ArrayList<TracerouteContainer>
        )
        listViewTraceroute.adapter = traceListAdapter
        buttonLaunch.setOnClickListener {
            if (editTextPing.text.isEmpty()) {
                Toast.makeText(this@TraceActivity, "No text", Toast.LENGTH_SHORT)
                    .show()
            } else {
                traces.clear()
                traceListAdapter.notifyDataSetChanged()
                startProgressBar()
                hideSoftwareKeyboard(editTextPing)
                tracerouteWithPing.executeTraceroute(editTextPing.text.toString(), maxTtl)
            }
        }
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
            traces.add(fTrace)
            traceListAdapter.notifyDataSetChanged()
        }
    }

    /**
     * Hides the keyboard
     *
     * @param currentEditText
     * The current selected edittext
     */
    fun hideSoftwareKeyboard(currentEditText: EditText) {
        val imm = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive) {
            imm.hideSoftInputFromWindow(
                currentEditText.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
    }

    fun startProgressBar() {
        progressBarPing.visibility = View.VISIBLE
    }

    fun stopProgressBar() {
        progressBarPing.visibility = View.GONE
    }

    companion object {
        const val tag = "TraceroutePing"
        const val INTENT_TRACE = "INTENT_TRACE"
    }
}