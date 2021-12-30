package com.example.auditsec.classes

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Handler
import android.provider.SyncStateContract.Helpers.update
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.auditsec.activities.MainActivity
import com.example.auditsec.fragments.TraceRoute
import com.synaptictools.traceroute.TraceRoute as traceroute
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.net.InetAddress
import java.util.*
import kotlin.Result.Companion.success


/**
 * This class contain everything needed to launch a traceroute using the ping command
 *
 */
class TracerouteWithPing(private val context: MainActivity, private val fragment: TraceRoute) {
    private var latestTrace: TracerouteContainer? = null
    private var ttl = 0
    private var finishedTasks = 0
    private var urlToPing: String? = null
    private var ipToPing: String? = null
    private var handlerTimeout: Handler? = null

    fun executeTraceroute(url: String, maxTtl: Int) {
        ttl = 1
        finishedTasks = 0
        urlToPing = url
        ExecutePingAsyncTask(maxTtl).execute()
    }

    private inner class TimeOutAsyncTask(
        private val task: ExecutePingAsyncTask?,
        private val ttlTask: Int
    ) : AsyncTask<Void?, Void?, Void?>() {
        override fun doInBackground(vararg params: Void?): Void? {
            return null
        }

        override fun onPostExecute(result: Void?) {
            if (handlerTimeout == null) {
                handlerTimeout = Handler()
            }

            // stop old timeout
            if (runnableTimeout != null) {
                handlerTimeout!!.removeCallbacks(runnableTimeout!!)
            }
            // define timeout
            runnableTimeout = Runnable {
                if (task != null) {
                    Log.e(
                        MainActivity.tag,
                        ttlTask.toString() + " task.isFinished()" + finishedTasks + " " + (ttlTask == finishedTasks)
                    )
                    if (ttlTask == finishedTasks) {
                        Toast.makeText(
                            context,
                            "Timed out!",
                            Toast.LENGTH_SHORT
                        ).show()
                        task.isCancelled = true
                        task.cancel(true)
                        fragment.stopProgressBar()
                    }
                }
            }
            // launch timeout after a delay
            handlerTimeout!!.postDelayed(runnableTimeout!!, TIMEOUT.toLong())
            super.onPostExecute(result)
        }
    }

    private inner class ExecutePingAsyncTask(private val maxTtl: Int) :
        AsyncTask<Void?, Void?, String>() {
        private val resultBuilder: StringBuilder = StringBuilder()
        private val _traceRouteResult: MutableLiveData<String> by lazy {
            MutableLiveData<String>()
        }
        private var cancelled = false


        override fun doInBackground(vararg params: Void?): String? {
            return if (hasConnectivity()) {
                try {
                    urlToPing?.let { launchPing(it) }
                } catch (e: Exception) {
                    context.runOnUiThread { onException(e) }
                }
                ""
            } else {
                "No connection"
            }
        }

        @SuppressLint("NewApi")
        @Throws(Exception::class)
        private fun launchPing(url: String): String {
            TimeOutAsyncTask(this, ttl).execute()

            try {
                traceroute.setCallback {
                    success {
                        resultBuilder.append("\ntraceroute finish")
                        _traceRouteResult.postValue(resultBuilder.toString())
                    }
                    update { text ->
                        resultBuilder.append(text)
                        _traceRouteResult.postValue(resultBuilder.toString())
                    }
                    failed { code, reason ->
                        resultBuilder.append("\ntraceroute failed:\n code: '$code', reason: '$reason'")
                        _traceRouteResult.postValue(resultBuilder.toString())
                    }
                }
                urlToPing?.let { traceroute.traceroute(it) }

                val scanner = Scanner(resultBuilder.toString())

                while (scanner.hasNextLine()) {
                    val res = scanner.nextLine()
                    if("""^\d+""".toRegex().find(res.trim())?.value == null) continue

                    val trace: TracerouteContainer = if (res.contains("*")) {
                        TracerouteContainer("*", "*", 0.toFloat(), false)
                    } else {
                        val ip = parseIpFromPing(res)
                        val inetAddr = InetAddress.getByName(ip)
                        val hostname = inetAddr.hostName

                        TracerouteContainer(
                            hostname,
                            ip,
                            parseTimeFromPing(res).toFloat(),
                            true
                        )
                    }

                    fragment.refreshList(trace)
                }
                scanner.close()
                fragment.stopProgressBar()
            } catch (e: Exception) {
                Toast.makeText(
                    context,
                    "Error!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            return resultBuilder.toString()
        }

        override fun onPostExecute(result: String) {
            if (!cancelled) {
                try {
                    if ("" != result) {
                        if ("No connection" == result) {
                            Toast.makeText(
                                context,
                                "No connection",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Log.d(MainActivity.tag, result)
                            if (latestTrace != null && latestTrace!!.ip == ipToPing) {
                                if (ttl < maxTtl) {
                                    ttl = maxTtl
                                    ExecutePingAsyncTask(maxTtl).execute()
                                } else {
                                    fragment.stopProgressBar()
                                }
                            } else {
                                if (ttl < maxTtl) {
                                    ttl++
                                    ExecutePingAsyncTask(maxTtl).execute()
                                }
                            }
                        }
                    }
                    finishedTasks++
                } catch (e: Exception) {
                    context.runOnUiThread { onException(e) }
                }
            }
            super.onPostExecute(result)
        }

        private fun onException(e: Exception) {
            Log.e(MainActivity.tag, e.toString())
            if (e is IllegalArgumentException) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                    .show()
            }
            fragment.stopProgressBar()
            finishedTasks++
        }

        fun setCancelled(cancelled: Boolean) {
            this.cancelled = cancelled
        }
    }

    private fun parseIpFromPing(ping: String): String {
        var ip = ""

        val indexOpen = ping.indexOf(PARENTHESE_OPEN_PING)
        val indexClose = ping.indexOf(PARENTHESE_CLOSE_PING)
        ip = ping.substring(indexOpen + 1, indexClose)

        return ip
    }

    private fun parseTimeFromPing(ping: String): String {
        return ping.trim().split(" ")[5]
    }

    fun hasConnectivity(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    companion object {
        private const val PARENTHESE_OPEN_PING = "("
        private const val PARENTHESE_CLOSE_PING = ")"

        private const val TIMEOUT = 30000
        private var runnableTimeout: Runnable? = null
    }
}