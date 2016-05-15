package com.greenlightdigital.analyzer.interfaces;

import com.greenlightdigital.analyzer.model.LogEntry;
import com.greenlightdigital.analyzer.model.RecentLogEntryContainer;

/**
 * @author Vladislav Naydenov
 *
 */
public interface IntrusionDetector {

	void addFailedLogin(LogEntry logEntry);
	
	RecentLogEntryContainer getLogEntryContainer();
}
