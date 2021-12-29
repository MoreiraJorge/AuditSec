package com.example.auditsec.classes

import com.google.gson.JsonParser

val PORT_DETAILS = JsonParser().parse(
        """{
        "1": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "TCP Port Service Multiplexer (TCPMUX). Historic. Both TCP and UDP have been assigned to TCPMUX by IANA, but by design only TCP is specified."
    },
        "5": {
        "tcp": "Assigned",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Remote Job Entry and IANA has assigned both TCP and UDP 5 to it."
    },
        "7": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Echo Protocol"
    },
        "9": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "Yes",
            "dccp": "",
            "description": "Discard Protocol"
        },
        {
            "tcp": "No",
            "udp": "Unofficial",
            "sctp": "",
            "dccp": "",
            "description": "Wake-on-LAN"
        }
        ],
        "11": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Active Users (systat service)"
    },
        "13": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Daytime Protocol"
    },
        "15": {
        "tcp": "Unofficial",
        "udp": "No",
        "sctp": "",
        "dccp": "",
        "description": "Previously netstat service"
    },
        "17": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Quote of the Day (QOTD)"
    },
        "18": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Message Send Protocol"
    },
        "19": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Character Generator Protocol (CHARGEN)"
    },
        "20": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "Yes",
        "dccp": "",
        "description": "File Transfer Protocol (FTP) data transfer"
    },
        "21": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "Yes",
        "dccp": "",
        "description": "File Transfer Protocol (FTP) control (command)"
    },
        "22": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "Yes",
        "dccp": "",
        "description": "Secure Shell (SSH), secure logins, file transfers (scp, sftp) and port forwarding"
    },
        "23": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Telnet protocol—unencrypted text communications"
    },
        "25": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Simple Mail Transfer Protocol (SMTP), used for email routing between mail servers"
    },
        "28": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Palo Alto Networks' Panorama High Availability (HA) sync encrypted port."
    },
        "37": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Time Protocol"
    },
        "42": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Host Name Server Protocol"
    },
        "43": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "WHOIS protocol"
    },
        "47": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "49": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "TACACS Login Host protocol."
    },
        "51": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": "Historically used for Interface Message Processor logical address management, entry has been removed by IANA on 2013-05-25"
    },
        "52": {
        "tcp": "Assigned",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Xerox Network Systems (XNS) Time Protocol. Despite this port being assigned by IANA, the service is meant to work on SPP (ancestor of IPX/SPX), instead of TCP/IP."
    },
        "53": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Domain Name System (DNS)"
    },
        "54": {
        "tcp": "Assigned",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Xerox Network Systems (XNS) Clearinghouse (Name Server). Despite this port being assigned by IANA, the service is meant to work on SPP (ancestor of IPX/SPX), instead of TCP/IP."
    },
        "56": {
        "tcp": "Assigned",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Xerox Network Systems (XNS) Authentication Protocol. Despite this port being assigned by IANA, the service is meant to work on SPP (ancestor of IPX/SPX), instead of TCP/IP."
    },
        "58": {
        "tcp": "Assigned",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Xerox Network Systems (XNS) Mail. Despite this port being assigned by IANA, the service is meant to work on SPP (ancestor of IPX/SPX), instead of TCP/IP."
    },
        "61": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": "Historically assigned to the NIFTP-Based Mail protocol,"
    },
        "67": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Bootstrap Protocol (BOOTP) server; also used by Dynamic Host Configuration Protocol (DHCP)"
    },
        "68": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Bootstrap Protocol (BOOTP) client; also used by Dynamic Host Configuration Protocol (DHCP)"
    },
        "69": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Trivial File Transfer Protocol (TFTP)"
    },
        "70": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Gopher protocol"
    },
        "71": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETRJS protocol"
    },
        "72": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETRJS protocol"
    },
        "73": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETRJS protocol"
    },
        "74": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETRJS protocol"
    },
        "79": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Finger protocol"
    },
        "80": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "Yes",
        "dccp": "",
        "description": "Hypertext Transfer Protocol (HTTP) a transport protocol on top of UDP."
    },
        "81": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "TorPark onion routing"
    },
        "82": {
        "tcp": "",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "TorPark control"
    },
        "83": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "MIT ML Device, networking file system"
    },
        "88": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Kerberos authentication system"
    },
        "90": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "PointCast (dotcom)"
    },
        "95": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "SUPDUP, terminal-independent remote login"
    },
        "101": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "NIC host name"
    },
        "102": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "ISO Transport Service Access Point (TSAP) Class 0 protocol"
    },
        "104": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Digital Imaging and Communications in Medicine (DICOM; also port 11112)"
    },
        "105": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "CCSO Nameserver"
    },
        "106": {
        "tcp": "Unofficial",
        "udp": "No",
        "sctp": "",
        "dccp": "",
        "description": "macOS Server, (macOS) password server"
    },
        "107": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Remote User Telnet Service (RTelnet)"
    },
        "108": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "IBM Systems Network Architecture (SNA) gateway access server"
    },
        "109": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Post Office Protocol, version 2 (POP2)"
    },
        "110": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Post Office Protocol, version 3 (POP3)"
    },
        "111": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Open Network Computing Remote Procedure Call ('''ONC RPC''', sometimes referred to as '''Sun RPC''')"
    },
        "113": [
        {
            "tcp": "Yes",
            "udp": "No",
            "sctp": "",
            "dccp": "",
            "description": "Ident, authentication service/identification protocol, used by IRC servers to identify users"
        },
        {
            "tcp": "Yes",
            "udp": "Assigned",
            "sctp": "",
            "dccp": "",
            "description": "Authentication Service (auth), the predecessor to identification protocol. Used to determine a user's identity of a particular TCP connection."
        }
        ],
        "115": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Simple File Transfer Protocol"
    },
        "117": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "UUCP Mapping Project (path service)"
    },
        "118": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Structured Query Language (SQL) Services"
    },
        "119": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Network News Transfer Protocol (NNTP), retrieval of newsgroup messages"
    },
        "123": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Network Time Protocol (NTP), used for time synchronization"
    },
        "126": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Formerly Unisys Unitary Login, renamed by Unisys to NXEdit. Used by Unisys Programmer's Workbench for Clearpath MCP, an IDE for Unisys MCP software development"
    },
        "135": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "DCE endpoint resolution"
        },
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Microsoft EPMAP (End Point Mapper), also known as DCE/RPC Locator service,[68] used to remotely manage services including DHCP server, DNS server and WINS. Also used by DCOM"
        }
        ],
        "137": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NetBIOS Name Service, used for name registration and resolution"
    },
        "138": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NetBIOS Datagram Service"
    },
        "139": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "NetBIOS Session Service"
    },
        "143": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Internet Message Access Protocol (IMAP),[11] management of electronic mail messages on a server"
    },
        "152": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Background File Transfer Program (BFTP)"
    },
        "153": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Simple Gateway Monitoring Protocol (SGMP), a protocol for remote inspection and alteration of gateway management information"
    },
        "156": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Structured Query Language (SQL) Service"
    },
        "158": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Distributed Mail System Protocol ('''DMSP''', sometimes referred to as '''Pcmail''')"
    },
        "161": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Simple Network Management Protocol (SNMP)"
    },
        "162": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Simple Network Management Protocol Trap (SNMPTRAP)"
    },
        "170": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Network PostScript print server"
    },
        "177": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "X Display Manager Control Protocol (XDMCP), used for remote logins to an X Display Manager server"
    },
        "179": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "Yes",
        "dccp": "",
        "description": "Border Gateway Protocol (BGP),[78] used to exchange routing and reachability information among autonomous systems (AS) on the Internet"
    },
        "194": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Internet Relay Chat (IRC)"
    },
        "199": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "SNMP Unix Multiplexer (SMUX)"
    },
        "201": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "AppleTalk Routing Maintenance"
    },
        "209": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Quick Mail Transfer Protocol"
    },
        "210": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "ANSI Z39.50"
    },
        "213": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Internetwork Packet Exchange (IPX)"
    },
        "218": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Message posting protocol (MPP)"
    },
        "220": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Internet Message Access Protocol (IMAP), version 3"
    },
        "225": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "226": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "227": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "228": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "229": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "230": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "231": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "232": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "233": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "234": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "235": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "236": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "237": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "238": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "239": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "240": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "241": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "249": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "250": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "251": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "252": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "253": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "254": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "255": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "259": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Efficient Short Remote Operations (ESRO)"
    },
        "262": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Arcisdms"
    },
        "264": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Border Gateway Multicast Protocol (BGMP)"
    },
        "280": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "http-mgmt"
    },
        "300": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "ThinLinc Web Access"
    },
        "308": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Novastor Online Backup"
    },
        "311": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "macOS Server Admin)"
    },
        "312": {
        "tcp": "Unofficial",
        "udp": "No",
        "sctp": "",
        "dccp": "",
        "description": "macOS Xsan administration"
    },
        "318": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "PKIX Time Stamp Protocol (TSP)"
    },
        "319": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Precision Time Protocol (PTP) event messages"
    },
        "320": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Precision Time Protocol (PTP) general messages"
    },
        "350": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Mapping of Airline Traffic over Internet Protocol (MATIP) type A"
    },
        "351": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "MATIP type B"
    },
        "356": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "cloanto-net-1 (used by Cloanto Amiga Explorer and VMs)"
    },
        "366": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "On-Demand Mail Relay (ODMR)"
    },
        "369": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Rpc2portmap"
    },
        "370": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "codaauth2, Coda authentication server"
        },
        {
            "tcp": "",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "securecast1, outgoing packets to NAI's SecureCast servers As of 2000"
        }
        ],
        "371": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "ClearCase albd"
    },
        "376": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Amiga Envoy Network Inquiry Protocol"
    },
        "383": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "HP data alarm manager"
    },
        "384": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "A Remote Network Server System"
    },
        "387": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "AURP (AppleTalk Update-based Routing Protocol)"
    },
        "388": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Unidata LDM near real-time data distribution protocol"
    },
        "389": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Lightweight Directory Access Protocol (LDAP)"
    },
        "399": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Digital Equipment Corporation DECnet+ (Phase V) over TCP/IP (RFC1859)"
    },
        "401": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Uninterruptible power supply (UPS)"
    },
        "427": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Service Location Protocol (SLP)"
    },
        "433": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NNTP, part of Network News Transfer Protocol"
    },
        "434": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Mobile IP Agent (RFC 5944)"
    },
        "443": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "Yes",
        "dccp": "",
        "description": "Hypertext Transfer Protocol Secure (HTTPS) a transport protocol on top of UDP."
    },
        "444": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Simple Network Paging Protocol (SNPP), RFC 1568"
    },
        "445": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Microsoft-DS (Directory Services) Active Directory, Windows shares"
        },
        {
            "tcp": "Yes",
            "udp": "Assigned",
            "sctp": "",
            "dccp": "",
            "description": "Microsoft-DS (Directory Services) SMB file sharing"
        }
        ],
        "464": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Kerberos Change/Set password"
    },
        "465": [
        {
            "tcp": "Yes",
            "udp": "No",
            "sctp": "",
            "dccp": "",
            "description": "SMTP over implicit SSL (obsolete)"
        },
        {
            "tcp": "Yes",
            "udp": "No",
            "sctp": "",
            "dccp": "",
            "description": "URL Rendezvous Directory for Cisco SSM (primary usage assignment)"
        },
        {
            "tcp": "Yes",
            "udp": "No",
            "sctp": "",
            "dccp": "",
            "description": "Authenticated SMTP over TLS/SSL (SMTPS) (alternative usage assignment)"
        }
        ],
        "475": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "tcpnethaspsrv, Aladdin Knowledge Systems Hasp services"
    },
        "476": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "477": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "478": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "479": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "480": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "481": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "482": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "483": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "484": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "485": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "486": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "487": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "488": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "489": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "490": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Centro Software ERP ports"
    },
        "491": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "GO-Global remote access and application publishing software"
    },
        "497": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Retrospect"
    },
        "500": {
        "tcp": "Assigned",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Internet Security Association and Key Management Protocol (ISAKMP) / Internet Key Exchange (IKE)"
    },
        "502": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Modbus Protocol"
    },
        "504": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Citadel, multiservice protocol for dedicated clients for the Citadel groupware system"
    },
        "510": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "FirstClass Protocol (FCP), used by FirstClass client/server groupware system"
    },
        "512": [
        {
            "tcp": "Yes",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "Rexec, Remote Process Execution"
        },
        {
            "tcp": "",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "comsat, together with biff"
        }
        ],
        "513": [
        {
            "tcp": "Yes",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "rlogin"
        },
        {
            "tcp": "",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Who"
        }
        ],
        "514": [
        {
            "tcp": "Unofficial",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "Remote Shell, used to execute non-interactive commands on a remote system (Remote Shell, rsh, remsh)"
        },
        {
            "tcp": "No",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Syslog, used for system logging"
        }
        ],
        "515": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Line Printer Daemon (LPD),[11] print service"
    },
        "517": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Talk"
    },
        "518": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NTalk"
    },
        "520": [
        {
            "tcp": "Yes",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "efs, extended file name server"
        },
        {
            "tcp": "",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Routing Information Protocol (RIP)"
        }
        ],
        "521": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Routing Information Protocol Next Generation (RIPng)"
    },
        "524": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NetWare Core Protocol (NCP) is used for a variety things such as access to primary NetWare server resources, Time Synchronization, etc."
    },
        "525": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Timed, Timeserver"
    },
        "530": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Remote procedure call (RPC)"
    },
        "532": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "netnews"
    },
        "533": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "netwall, For Emergency Broadcasts"
    },
        "540": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Unix-to-Unix Copy Protocol (UUCP)"
    },
        "542": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "commerce (Commerce Applications)"
    },
        "543": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "klogin, Kerberos login"
    },
        "544": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "kshell, Kerberos Remote shell"
    },
        "546": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "DHCPv6 client"
    },
        "547": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "DHCPv6 server"
    },
        "548": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Apple Filing Protocol (AFP) over TCP"
    },
        "550": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "new-rwho, new-who"
    },
        "554": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Real Time Streaming Protocol (RTSP)"
    },
        "556": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Remotefs, RFS, rfs_server"
    },
        "560": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "rmonitor, Remote Monitor"
    },
        "561": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "monitor"
    },
        "563": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NNTP over TLS/SSL (NNTPS)"
    },
        "564": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "9P (Plan 9)"
    },
        "585": {
        "tcp": "No",
        "udp": "No",
        "sctp": "",
        "dccp": "",
        "description": "Previously assigned for use of Internet Message Access Protocol over TLS/SSL (IMAPS), now deregisterd in favour of port 993."
    },
        "587": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "email message submission (SMTP)"
    },
        "591": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "FileMaker 6.0 (and later) Web Sharing (HTTP Alternate, also see port 80)"
    },
        "593": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "HTTP RPC Ep Map, Remote procedure call over Hypertext Transfer Protocol, often used by Distributed Component Object Model services and Microsoft Exchange Server"
    },
        "601": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Reliable Syslog Service — used for system logging"
    },
        "604": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "TUNNEL profile, a protocol for BEEP peers to form an application layer tunnel"
    },
        "623": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "ASF Remote Management and Control Protocol (ASF-RMCP) & IPMI Remote Management Protocol"
    },
        "625": {
        "tcp": "Unofficial",
        "udp": "No",
        "sctp": "",
        "dccp": "",
        "description": "Open Directory Proxy (ODProxy)"
    },
        "631": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Internet Printing Protocol (IPP)"
        },
        {
            "tcp": "Unofficial",
            "udp": "Unofficial",
            "sctp": "",
            "dccp": "",
            "description": "Common Unix Printing System (CUPS) administration console (extension to IPP)"
        }
        ],
        "635": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "RLZ DBase"
    },
        "636": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Lightweight Directory Access Protocol over TLS/SSL (LDAPS)"
    },
        "639": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Multicast Source Discovery Protocol, MSDP"
    },
        "641": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "SupportSoft Nexus Remote Command (control/listening), a proxy gateway connecting remote control traffic"
    },
        "643": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "SANity"
    },
        "646": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Label Distribution Protocol (LDP), a routing protocol used in MPLS networks"
    },
        "647": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "DHCP Failover protocol"
    },
        "648": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Registry Registrar Protocol (RRP)"
    },
        "651": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "IEEE-MMS"
    },
        "653": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "SupportSoft Nexus Remote Command (data), a proxy gateway connecting remote control traffic"
    },
        "654": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Media Management System (MMS) Media Management Protocol (MMP)"
    },
        "655": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Tinc VPN daemon"
    },
        "657": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "IBM RMC (Remote monitoring and Control) protocol, used by System p5 AIX Integrated Virtualization Manager (IVM)[97] and Hardware Management Console to connect managed logical partitions (LPAR) to enable dynamic partition reconfiguration"
    },
        "660": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "macOS Server administration,"
    },
        "666": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Doom, first online first-person shooter"
        },
        {
            "tcp": "Unofficial",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "airserv-ng, aircrack-ng's server for remote-controlling wireless devices"
        }
        ],
        "674": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Application Configuration Access Protocol (ACAP)"
    },
        "688": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "REALM-RUSD (ApplianceWare Server Appliance Management Protocol)"
    },
        "690": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Velneo Application Transfer Protocol (VATP)"
    },
        "691": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "MS Exchange Routing"
    },
        "694": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Linux-HA high-availability heartbeat"
    },
        "695": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "IEEE Media Management System over SSL (IEEE-MMS-SSL)"
    },
        "698": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Optimized Link State Routing protocol (OLSR)"
    },
        "700": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Extensible Provisioning Protocol (EPP), a protocol for communication between domain name registries and registrars (RFC 5734)"
    },
        "701": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Link Management Protocol (LMP),[99] a protocol that runs between a pair of nodes and is used to manage traffic engineering (TE) links"
    },
        "702": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "IRIS (RFC 3983)"
    },
        "706": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Secure Internet Live Conferencing (SILC)"
    },
        "711": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Cisco Tag Distribution Protocol"
    },
        "712": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Topology Broadcast based on Reverse-Path Forwarding routing protocol (TBRPF; RFC 3684)"
    },
        "749": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Kerberos (protocol) administration"
    },
        "750": {
        "tcp": "",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "kerberos-iv, Kerberos version IV"
    },
        "751": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "kerberos_master, Kerberos authentication"
    },
        "752": {
        "tcp": "",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "passwd_server, Kerberos password (kpasswd) server"
    },
        "753": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "Reverse Routing Header (RRH)"
        },
        {
            "tcp": "",
            "udp": "Unofficial",
            "sctp": "",
            "dccp": "",
            "description": "userreg_server, Kerberos userreg server"
        }
        ],
        "754": [
        {
            "tcp": "Yes",
            "udp": "Yes",
            "sctp": "",
            "dccp": "",
            "description": "tell send"
        },
        {
            "tcp": "Unofficial",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "krb5_prop, Kerberos v5 slave propagation"
        }
        ],
        "760": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "krbupdate [kreg], Kerberos registration"
    },
        "782": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Conserver serial-console management server"
    },
        "783": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "SpamAssassin spamd daemon"
    },
        "800": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "mdbs-daemon"
    },
        "802": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "MODBUS/TCP Security"
    },
        "808": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Microsoft Net.TCP Port Sharing Service"
    },
        "829": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Certificate Management Protocol"
    },
        "830": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETCONF over SSH"
    },
        "831": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETCONF over BEEP"
    },
        "832": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETCONF for SOAP over HTTPS"
    },
        "833": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "NETCONF for SOAP over BEEP"
    },
        "843": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Adobe Flash"
    },
        "847": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "DHCP Failover protocol"
    },
        "848": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Group Domain Of Interpretation (GDOI) protocol"
    },
        "853": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "DNS over TLS (RFC 7858)"
    },
        "860": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "iSCSI (RFC 3720)"
    },
        "861": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "OWAMP control (RFC 4656)"
    },
        "862": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "TWAMP control (RFC 5357)"
    },
        "873": {
        "tcp": "Yes",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "rsync file synchronization protocol"
    },
        "888": [
        {
            "tcp": "Unofficial",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "cddbp, CD DataBase (CDDB) protocol (CDDBP)"
        },
        {
            "tcp": "Unofficial",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "IBM Endpoint Manager Remote Control"
        }
        ],
        "897": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Brocade SMI-S RPC"
    },
        "898": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "Brocade SMI-S RPC SSL"
    },
        "902": {
        "tcp": "Unofficial",
        "udp": "Unofficial",
        "sctp": "",
        "dccp": "",
        "description": "VMware ESXi"
    },
        "903": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "VMware ESXi"
    },
        "953": {
        "tcp": "Yes",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": "BIND remote name daemon control (RNDC)"
    },
        "981": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Remote HTTPS management for firewall devices running embedded Check Point VPN-1 software"
    },
        "987": [
        {
            "tcp": "Unofficial",
            "udp": "",
            "sctp": "",
            "dccp": "",
            "description": "Sony PlayStation Wake On Lan"
        },
        {
            "tcp": "",
            "udp": "Unofficial",
            "sctp": "",
            "dccp": "",
            "description": "Microsoft Remote Web Workplace, a feature of Windows Small Business Server"
        }
        ],
        "988": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "Lustre (file system) Protocol (data)."
    },
        "989": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "FTPS Protocol (data), FTP over TLS/SSL"
    },
        "990": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "FTPS Protocol (control), FTP over TLS/SSL"
    },
        "991": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Netnews Administration System (NAS)"
    },
        "992": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Telnet protocol over TLS/SSL"
    },
        "993": {
        "tcp": "Yes",
        "udp": "Assigned",
        "sctp": "",
        "dccp": "",
        "description": "Internet Message Access Protocol over TLS/SSL (IMAPS)"
    },
        "994": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": "Previously assigned to Internet Relay Chat over TLS/SSL (IRCS), but was not used in common practice."
    },
        "995": {
        "tcp": "Yes",
        "udp": "Yes",
        "sctp": "",
        "dccp": "",
        "description": "Post Office Protocol 3 over TLS/SSL (POP3S)"
    },
        "1010": {
        "tcp": "Unofficial",
        "udp": "",
        "sctp": "",
        "dccp": "",
        "description": "ThinLinc web-based administration interface"
    },
        "1011": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1012": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1013": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1014": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1015": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1016": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1017": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1018": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1019": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    },
        "1020": {
        "tcp": "Reserved",
        "udp": "Reserved",
        "sctp": "",
        "dccp": "",
        "description": ""
    }
}""").asJsonObject
