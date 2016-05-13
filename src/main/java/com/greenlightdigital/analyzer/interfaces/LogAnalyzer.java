package com.greenlightdigital.analyzer.interfaces;

import com.greenlightdigital.analyzer.model.LogEntry;

/**
 * @author vladislav.naydenov
 *
 */
public interface LogAnalyzer {

	LogEntry parseLine(String line);
}
