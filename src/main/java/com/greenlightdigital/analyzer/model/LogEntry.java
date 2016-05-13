package com.greenlightdigital.analyzer.model;

/**
 * @author Vladislav Naydenov
 *
 */
public class LogEntry {

	private String ipAddress;
	private String epochTime;
	private ELoginStatus loginStatus;
	private String userName;
	
	public LogEntry(String ipAddress, String epochTime, ELoginStatus loginStatus, String userName) {
		this.ipAddress = ipAddress;
		this.epochTime = epochTime;
		this.loginStatus = loginStatus;
		this.userName = userName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public String getEpochTime() {
		return epochTime;
	}

	public ELoginStatus getLoginStatus() {
		return loginStatus;
	}

	public String getUserName() {
		return userName;
	}
}
