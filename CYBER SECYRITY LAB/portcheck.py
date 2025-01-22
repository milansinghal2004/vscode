# •	Detect when a single source IP address attempts to connect to multiple ports on a destination IP address in a short time frame (e.g., within 5 seconds).
# •	Flag such activity as potential port scanning and print a report that includes the source IP, destination IP, the range of ports scanned, and the timestamp of the first and last detected scan.

import pyshark
from collections import defaultdict
from datetime import datetime

# Path to the .pcap file
pcap_file = 'CyberSecurity_Lab//capture.pcap'

def detect_port_scanning(pcap_file, time_window=5, port_threshold=5):
    # Open the capture file with a display filter for TCP packets
    cap = pyshark.FileCapture(pcap_file, display_filter="tcp")

    # Dictionary to store source IP, destination IP, and a list of (destination_port, timestamp)
    connections = defaultdict(list)

    print("Initializing Port Scanning Detection...\n")

    for packet in cap:
        try:
            # Extract relevant fields from the packet
            if 'IP' in packet and 'TCP' in packet:
                src_ip = packet.ip.src
                dst_ip = packet.ip.dst
                dst_port = packet.tcp.dstport
                timestamp = float(packet.sniff_time.timestamp())  # Get timestamp of the packet

                # Store the destination port and timestamp for the (src_ip, dst_ip) pair
                connections[(src_ip, dst_ip)].append((dst_port, timestamp))

        except AttributeError:
            continue

    # Close the capture file
    cap.close()

    # Now check each source IP - destination IP pair for port scanning behavior
    print("\nPotential Port Scanning Detected:")
    print(f"{'Source IP':<15} {'Destination IP':<15} {'Port Range':<15} {'First Scan Time':<20} {'Last Scan Time':<20} {'Scanned Ports'}")
    print("-" * 90)

    for (src_ip, dst_ip), ports in connections.items():
        # Sort ports by timestamp
        ports.sort(key=lambda x: x[1])

        # Check if the number of distinct ports accessed is greater than the threshold
        port_scans = defaultdict(list)
        for port, timestamp in ports:
            port_scans[port].append(timestamp)

        # Check for potential port scan
        if len(port_scans) >= port_threshold:
            first_scan_time = datetime.fromtimestamp(ports[0][1])
            last_scan_time = datetime.fromtimestamp(ports[-1][1])

            # Filter ports scanned within the time window
            scanned_ports = [port for port, timestamps in port_scans.items() if
                             timestamps[-1] - timestamps[0] <= time_window]

            if scanned_ports:
                print(f"{src_ip:<15} {dst_ip:<15} {min(scanned_ports)}-{max(scanned_ports):<15} {first_scan_time:<20} {last_scan_time:<20} {scanned_ports}")

# Main function to execute the task
def main():
    capture_file = r"CyberSecurity_Lab//capture.pcap"  # Replace with your .pcap file path
    detect_port_scanning(capture_file)

if __name__ == "__main__":
    main()
