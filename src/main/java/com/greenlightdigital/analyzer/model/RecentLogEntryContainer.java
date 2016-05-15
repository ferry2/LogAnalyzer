package com.greenlightdigital.analyzer.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.buffer.CircularFifoBuffer;

/**
 * @author Vladislav Naydenov
 *
 */
public class RecentLogEntryContainer {

	private Map<Integer, CircularFifoBuffer> circularFifoBufferMap;
	
	public RecentLogEntryContainer() {
		circularFifoBufferMap = new HashMap<Integer, CircularFifoBuffer>();
	}
	
	public void addLogEntry(LogEntry logEntry) {
		Integer ipAsInt = convertIpToInteger(logEntry.getIpAddress());
		
		if (!circularFifoBufferMap.containsKey(ipAsInt)) {
			circularFifoBufferMap.put(ipAsInt, new CircularFifoBuffer(5));
			circularFifoBufferMap.get(ipAsInt).add(logEntry);
		} else {
			circularFifoBufferMap.get(ipAsInt).add(logEntry);
		}
	}
	
	public Map<Integer, CircularFifoBuffer> getEntries() {
		return circularFifoBufferMap;
	}
	
	private Integer convertIpToInteger(String ipAddress) {
		String[] octets = ipAddress.split("\\.");
		
		if (octets.length < 4 || octets.length > 4) {
			throw new IllegalArgumentException(String.format("%s is not a valid IP Address", ipAddress));
		}
		
		return 96 * Integer.parseInt(octets[0]) + 156 * Integer.parseInt(octets[1]) + 210 * Integer.parseInt(octets[2]) + 192 * Integer.parseInt(octets[3]); 
	}
}
