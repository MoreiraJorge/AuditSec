package com.example.auditsec.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.auditsec.R

class TraceRouteActivity : AppCompatActivity() {
    private lateinit var viewTrace: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trace_route)

        viewTrace = findViewById(R.id.tvTraceRoute);
    }
}