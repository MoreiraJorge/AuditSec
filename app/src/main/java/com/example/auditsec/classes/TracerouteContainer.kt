package com.example.auditsec.classes

import java.io.Serializable

class TracerouteContainer(
    var hostname: String,
    var ip: String,
    var ms: Float,
    var isSuccessful: Boolean
) : Serializable {
    override fun toString(): String {
        return "Traceroute : \nHostname : $hostname\nip : $ip\nMilliseconds : $ms"
    }
    companion object {
        private const val serialVersionUID = 1034744411998219581L
    }
}