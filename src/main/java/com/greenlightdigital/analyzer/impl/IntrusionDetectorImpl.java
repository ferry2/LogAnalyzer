package com.greenlightdigital.analyzer.impl;

import com.greenlightdigital.analyzer.interfaces.IntrusionDetector;
import com.greenlightdigital.analyzer.model.LogEntry;
import com.greenlightdigital.analyzer.model.RecentLogEntryContainer;

/**
 * @author Vladislav Naydenov
 *
 */
public class IntrusionDetectorImpl implements IntrusionDetector {

	private RecentLogEntryContainer recentLogEntryContainer = new RecentLogEntryContainer();
	
	public void addFailedLogin(LogEntry logEntry) {
		if (logEntry.isSuccessful()) {
			return;
		}
		
		recentLogEntryContainer.addLogEntry(logEntry);
	}
}
