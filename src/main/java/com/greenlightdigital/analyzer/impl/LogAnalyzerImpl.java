package com.greenlightdigital.analyzer.impl;

import com.greenlightdigital.analyzer.interfaces.LogAnalyzer;
import com.greenlightdigital.analyzer.model.ELoginStatus;
import com.greenlightdigital.analyzer.model.LogEntry;
import com.greenlightdigital.validator.LogEntryChecker;

/**
 * @author Vladislav Naydenov
 *
 */
public class LogAnalyzerImpl implements LogAnalyzer {

	/* (non-Javadoc)
	 * @see com.greenlightdigital.analyzer.interfaces.LogAnalyzer#parseLine(java.lang.String)
	 */
	public LogEntry parseLine(String line) {
		String[] lineChunks = line.split(",");
		
		String ipAddress = null;
		String epochTime = null;
		ELoginStatus loginStatus = null;
		String userName = null;
		
		for (String chunk : lineChunks) {
			if (LogEntryChecker.isValidIpAddress(chunk)) {
				ipAddress = chunk;
			}
			
			if (LogEntryChecker.isValidTimeInMillis(Long.parseLong(chunk))) {
				epochTime = chunk;
			}
			
			if (LogEntryChecker.isValidUserName(chunk)) {
				userName = chunk;
			}
			
			ELoginStatus tempStatus = ELoginStatus.of(chunk);
			if (!ELoginStatus.UNKNOWN.equals(tempStatus)) {
				loginStatus = tempStatus;
			}
		}
		
		return new LogEntry(ipAddress, epochTime, loginStatus, userName);
	}

}
