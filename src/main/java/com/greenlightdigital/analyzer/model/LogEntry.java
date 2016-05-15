package com.greenlightdigital.analyzer.model;

import java.util.Date;

/**
 * @author Vladislav Naydenov
 *
 */
public class LogEntry {

	private String ipAddress;
	private Date epochTime;
	private ELoginStatus loginStatus;
	private String userName;
	
	public LogEntry(String ipAddress, Date epochTime, ELoginStatus loginStatus, String userName) {
		this.ipAddress = ipAddress;
		this.epochTime = epochTime;
		this.loginStatus = loginStatus;
		this.userName = userName;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public Date getEpochTime() {
		return epochTime;
	}

	public ELoginStatus getLoginStatus() {
		return loginStatus;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epochTime == null) ? 0 : epochTime.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((loginStatus == null) ? 0 : loginStatus.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogEntry other = (LogEntry) obj;
		if (epochTime == null) {
			if (other.epochTime != null)
				return false;
		} else if (!epochTime.equals(other.epochTime))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (loginStatus != other.loginStatus)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LogEntry [ipAddress=" + ipAddress + ", epochTime=" + epochTime + ", loginStatus=" + loginStatus
				+ ", userName=" + userName + "]";
	}
}
