package com.greenlightdigital.analyzer.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections.buffer.CircularFifoBuffer;

import com.greenlightdigital.analyzer.interfaces.IntrusionDetectorManual;
import com.greenlightdigital.analyzer.model.LogEntry;

/**
 * @author Vladislav Naydenov
 *
 */
public class IntrusionDetectorManualImpl implements IntrusionDetectorManual {

	public void clean(Map<Integer, CircularFifoBuffer> loginsMap) {
		for (Entry<Integer, CircularFifoBuffer> entry : loginsMap.entrySet()) {
			@SuppressWarnings("rawtypes")
			Iterator iterator = entry.getValue().iterator();
			while (iterator.hasNext()) {
				LogEntry logEntry = (LogEntry) iterator.next();
				// If current time minus 5 minutes is less than login time remove the entry 
				if (logEntry.getEpochTime().compareTo(getCurrentTimeMinusFiveMinutes()) < 0) {
					entry.getValue().remove();
				}
			}
		}
	}
	
	private Date getCurrentTimeMinusFiveMinutes() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.MINUTE, -5);
		
		return calendar.getTime();
	}
}
