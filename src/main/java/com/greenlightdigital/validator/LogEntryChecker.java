package com.greenlightdigital.validator;

import java.util.regex.Pattern;

import org.apache.commons.validator.routines.InetAddressValidator;

public class LogEntryChecker {

	private static final Pattern USER_NAME_PATTERN = Pattern.compile("^([A-Za-z]+)\\.([A-Za-z]+)$");
	
	public static boolean isValidIpAddress(String ipAddress) {
		return InetAddressValidator.getInstance().isValid(ipAddress);
	}
	
	public static boolean isValidTimeInMillis(String epochTime) {
		Long millis = null;
		try {
			millis = Long.parseLong(epochTime);
		} catch (NumberFormatException e) {
			return false;
		}
		
		return millis < System.currentTimeMillis();
	}
	
	public static boolean isValidUserName(String userName) {
		return USER_NAME_PATTERN.matcher(userName).matches();
	}
}
