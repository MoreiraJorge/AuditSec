package com.example.auditsec.classes
import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.AsyncTask
import android.os.Handler
import android.util.Log
import android.widget.Toast
import com.example.auditsec.activities.TraceActivity
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.net.InetAddress


/**
 * This class contain everything needed to launch a traceroute using the ping command
 *
 */
class TracerouteWithPing(private val context: TraceActivity) {
    private var latestTrace: TracerouteContainer? = null
    private var ttl = 0
    private var finishedTasks = 0
    private var urlToPing: String? = null
    private var ipToPing: String? = null
    private var elapsedTime = 0f
    private var handlerTimeout: Handler? = null

    /**
     * Launches the Traceroute
     *
     * @param url
     * The url to trace
     * @param maxTtl
     * The max time to live to set (ping param)
     */
    fun executeTraceroute(url: String?, maxTtl: Int) {
        ttl = 1
        finishedTasks = 0
        urlToPing = url
        ExecutePingAsyncTask(maxTtl).execute()
    }

    /**
     * Allows to timeout the ping if TIMEOUT exceeds. (-w and -W are not always supported on Android)
     */
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
                        TraceActivity.tag,
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
                        context.stopProgressBar()
                    }
                }
            }
            // launch timeout after a delay
            handlerTimeout!!.postDelayed(runnableTimeout!!, TIMEOUT.toLong())
            super.onPostExecute(result)
        }
    }

    /**
     * The task that ping an ip, with increasing time to live (ttl) value
     */
    private inner class ExecutePingAsyncTask(private val maxTtl: Int) :
        AsyncTask<Void?, Void?, String>() {
        private var cancelled = false

        /**
         * Launches the ping, launches InetAddress to retrieve url if there is one, store trace
         */
        protected override fun doInBackground(vararg params: Void?): String? {
            if (hasConnectivity()) {
                //try {
                    val res = launchPing(urlToPing)
                    val trace: TracerouteContainer
                    val ip = parseIpFromPing(res)
                    trace = if (res.contains(UNREACHABLE_PING) && !res.contains(EXCEED_PING)) {
                        // Create the TracerouteContainer object when ping
                        // failed
                        TracerouteContainer("", ip, elapsedTime, false)
                    } else {
                        // Create the TracerouteContainer object when succeed
                        TracerouteContainer(
                            "",
                            ip,
                            if (ttl == maxTtl) parseTimeFromPing(res).toFloat() else elapsedTime,
                            true
                        )
                    }

                    // Get the host name from ip (unix ping do not support
                    // hostname resolving)
                    val inetAddr = InetAddress.getByName(trace.ip)
                    val hostname = inetAddr.hostName
                    val canonicalHostname = inetAddr.canonicalHostName
                    trace.hostname = hostname
                    latestTrace = trace
                    Log.d(TraceActivity.tag, "hostname : $hostname")
                    Log.d(TraceActivity.tag, "canonicalHostname : $canonicalHostname")

                    // Store the TracerouteContainer object
                    Log.d(TraceActivity.tag, trace.toString())

                    // Not refresh list if this ip is the final ip but the ttl is not maxTtl
                    // this row will be inserted later
                    if (ip != ipToPing || ttl == maxTtl) {
                        context.refreshList(trace)
                    }
                    return res
               // } catch (e: Exception) {
                 //   context.runOnUiThread { onException(e) }
               // }
            } else {
                return "No connection"
            }
            return ""
        }

        /**
         * Launches ping command
         *
         * @param url
         * The url to ping
         * @return The ping string
         */
        @SuppressLint("NewApi")
        @Throws(Exception::class)
        private fun launchPing(url: String?): String {
            //TODO: O CODIGO QUE USEI PARA TESTAR FOI ESTE!
            /*
            val rt = Runtime.getRuntime()
            val commands = arrayOf("ping", "google.pt")
            val proc = rt.exec(commands)

            val stdInput1 = BufferedReader(InputStreamReader(proc.inputStream))

            val stdError = BufferedReader(InputStreamReader(proc.errorStream))

            // Read the output from the command
            println("Here is the standard output of the command:\n")
            var s: String? = null
            while (stdInput1.readLine().also { s = it } != null) {
                println("OUTPUT====> $s")
            }

            // Read any errors from the attempted command
            println("Here is the standard error of the command (if any):\n")
            while (stdError.readLine().also { s = it } != null) {
                println("OUTPUT====> $s")
            }

            return ""

             */

            // Build ping command with parameters
            val p: Process
            //var command = ""
            val format = "ping google.pt -t 1 -c 1"
            //command = String.format(format, ttl)
            val commands = arrayOf("ping", "-c", "1", "-t", "1", "google.pt")
            Log.d(TraceActivity.tag, "Will launch : $commands$url")
            val startTime = System.nanoTime()
            elapsedTime = 0f
            // timeout task
            TimeOutAsyncTask(this, ttl).execute()
            // Launch command
            p = Runtime.getRuntime().exec(commands)
            val stdInput = BufferedReader(InputStreamReader(p.inputStream))

            // Construct the response from ping
            var s: String? = null
            var res = ""
            while (stdInput.readLine().also { s = it } != null) {
                println("OUTPUT====> $s")
                res += """
                    $s
                    
                    """.trimIndent()
                if (s!!.contains(FROM_PING) || s!!.contains(SMALL_FROM_PING)) {
                    // We store the elapsedTime when the line from ping comes
                    elapsedTime = (System.nanoTime() - startTime) / 1000000.0f
                }
            }
            p.destroy()
            require(res != "")

            // Store the wanted ip adress to compare with ping result
            if (ttl == 1) {
                println("RES -> " + res)
                ipToPing = parseIpToPingFromPing(res)
            }
            return res
        }

        /**
         * Treat the previous ping (launches a ttl+1 if it is not the final ip, refresh the list on view etc...)
         */
        override fun onPostExecute(result: String) {
            if (!cancelled) {
                //try {
                    if ("" != result) {
                        if ("No connection" == result) {
                            Toast.makeText(
                                context,
                                "No connection",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Log.d(TraceActivity.tag, result)
                            if (latestTrace != null && latestTrace!!.ip == ipToPing) {
                                if (ttl < maxTtl) {
                                    ttl = maxTtl
                                    ExecutePingAsyncTask(maxTtl).execute()
                                } else {
                                    context.stopProgressBar()
                                }
                            } else {
                                if (ttl < maxTtl) {
                                    ttl++
                                    ExecutePingAsyncTask(maxTtl).execute()
                                }
                            }
                            //TODO: /!\ JORGE É SUPOSTO ISTO ESTAR COMENTADO? DEPOIS VÊ PFF PODE FALTAR ATUALIZAR A LISTA
                            //context.refreshList(traces);
                        }
                    }
                    finishedTasks++
                //} catch (e: Exception) {
                    //context.runOnUiThread { onException(e) }
                //}
            }
            super.onPostExecute(result)
        }

        /**
         * Handles exception on ping
         *
         * @param e
         * The exception thrown
         */
        private fun onException(e: Exception) {
            Log.e(TraceActivity.tag, e.toString())
            if (e is IllegalArgumentException) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT)
                    .show()
            }
            context.stopProgressBar()
            finishedTasks++
        }

        fun setCancelled(cancelled: Boolean) {
            this.cancelled = cancelled
        }
    }

    /**
     * Gets the ip from the string returned by a ping
     *
     * @param ping
     * The string returned by a ping command
     * @return The ip contained in the ping
     */
    private fun parseIpFromPing(ping: String): String {
        var ip = ""
        if (ping.contains(FROM_PING)) {
            // Get ip when ttl exceeded
            var index = ping.indexOf(FROM_PING)
            ip = ping.substring(index + 5)
            if (ip.contains(PARENTHESE_OPEN_PING)) {
                // Get ip when in parenthese
                val indexOpen = ip.indexOf(PARENTHESE_OPEN_PING)
                val indexClose = ip.indexOf(PARENTHESE_CLOSE_PING)
                ip = ip.substring(indexOpen + 1, indexClose)
            } else {
                // Get ip when after from
                ip = ip.substring(0, ip.indexOf("\n"))
                index = if (ip.contains(":")) {
                    ip.indexOf(":")
                } else {
                    ip.indexOf(" ")
                }
                ip = ip.substring(0, index)
            }
        } else {
            // Get ip when ping succeeded
            val indexOpen = ping.indexOf(PARENTHESE_OPEN_PING)
            val indexClose = ping.indexOf(PARENTHESE_CLOSE_PING)
            ip = ping.substring(indexOpen + 1, indexClose)
        }
        return ip
    }

    /**
     * Gets the final ip we want to ping (example: if user fullfilled google.fr, final ip could be 8.8.8.8)
     *
     * @param ping
     * The string returned by a ping command
     * @return The ip contained in the ping
     */
    private fun parseIpToPingFromPing(ping: String): String {
        var ip = ""
        if (ping.contains(PING)) {
            println("PIING VALUE " + ping)
            // Get ip when ping succeeded
            val indexOpen = ping.indexOf(PARENTHESE_OPEN_PING)
            val indexClose = ping.indexOf(PARENTHESE_CLOSE_PING)
            ip = ping.substring(indexOpen + 1, indexClose)
        }
        return ip
    }

    /**
     * Gets the time from ping command (if there is)
     *
     * @param ping
     * The string returned by a ping command
     * @return The time contained in the ping
     */
    private fun parseTimeFromPing(ping: String): String {
        var time = ""
        if (ping.contains(TIME_PING)) {
            var index = ping.indexOf(TIME_PING)
            time = ping.substring(index + 5)
            index = time.indexOf(" ")
            time = time.substring(0, index)
        }
        return time
    }

    /**
     * Check for connectivity (wifi and mobile)
     *
     * @return true if there is a connectivity, false otherwise
     */
    fun hasConnectivity(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    companion object {
        private const val PING = "PING"
        private const val FROM_PING = "From"
        private const val SMALL_FROM_PING = "from"
        private const val PARENTHESE_OPEN_PING = "("
        private const val PARENTHESE_CLOSE_PING = ")"
        private const val TIME_PING = "time="
        private const val EXCEED_PING = "exceed"
        private const val UNREACHABLE_PING = "100%"

        // timeout handling
        private const val TIMEOUT = 30000
        private var runnableTimeout: Runnable? = null
    }
}