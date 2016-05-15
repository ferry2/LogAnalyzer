package com.greenlightdigital.analyzer.interfaces;

import com.greenlightdigital.analyzer.model.LogEntry;

/**
 * @author Vladislav Naydenov
 *
 */
public interface IntrusionDetector {

	void addFailedLogin(LogEntry logEntry);
}
