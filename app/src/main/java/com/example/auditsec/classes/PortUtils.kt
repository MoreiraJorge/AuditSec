package com.example.auditsec.classes

object PortUtils {
    fun retrievePorts(portsString: String): ArrayList<Int> {
        val portsList = portsString.split(',')
        var ports: Set<Int> = mutableSetOf()

        portsList.forEach {
            val portRange = it.trim().split('-')
            if(portRange.size == 1) {
                ports += (portRange[0].trim().toInt())
            } else {
                val startPort: Int = portRange[0].trim().toInt()
                val endPort: Int = portRange[1].trim().toInt()
                val portsInRange = listOf(startPort..endPort).flatten()

                ports += portsInRange.toSet()
            }
        }

        return ports.toCollection(ArrayList())
    }
}