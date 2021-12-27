package com.example.auditsec.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.auditsec.R
import com.example.auditsec.activities.MainActivity
import com.example.auditsec.adapters.TraceListAdapter
import com.example.auditsec.classes.TracerouteContainer
import com.example.auditsec.classes.TracerouteWithPing

class TraceRoute : Fragment(R.layout.fragment_trace_route) {
    private lateinit var buttonLaunch: Button;
    private lateinit var editTextPing: EditText;
    private lateinit var progressBarPing: ProgressBar;
    private lateinit var listViewTraceroute: ListView
    private lateinit var traceListAdapter: TraceListAdapter
    private lateinit var tracerouteWithPing: TracerouteWithPing;
    private lateinit var traces: MutableList<TracerouteContainer>;

    private val maxTtl = 40

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_trace_route, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tracerouteWithPing = TracerouteWithPing(this.context as MainActivity, this)
        traces = ArrayList()
        buttonLaunch = view.findViewById(R.id.buttonLaunch)
        editTextPing = view.findViewById(R.id.editTextPing)
        listViewTraceroute = view.findViewById(R.id.listViewTraceroute)
        progressBarPing = view.findViewById(R.id.progressBarPing)

        initView()
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun initView() {
        traceListAdapter = this.context?.let {
            TraceListAdapter(
                it,
                traces as ArrayList<TracerouteContainer>
            )
        }!!
        listViewTraceroute.adapter = traceListAdapter
        buttonLaunch.setOnClickListener {
            if (editTextPing.text.isEmpty()) {
                Toast.makeText(this.context, "No text", Toast.LENGTH_SHORT)
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
        activity?.runOnUiThread {
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
        val imm =
            activity?.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE) as InputMethodManager
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
}