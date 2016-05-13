package com.greenlightdigital.validator;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.validator.routines.InetAddressValidator;

public class LogEntryChecker {

	private static final Pattern USER_NAME_PATTERN = Pattern.compile("([a-zA-Z])|\\.([a-zA-Z])");
	
	public static boolean isValidIpAddress(String ipAddress) {
		return InetAddressValidator.getInstance().isValid(ipAddress);
	}
	
	public static boolean isValidTimeInMillis(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		Date timeInMillis = new Date(millis);
		
		return (calendar.getTime().compareTo(timeInMillis) < 0 && millis < System.currentTimeMillis());
	}
	
	public static boolean isValidUserName(String userName) {
		return USER_NAME_PATTERN.matcher(userName).matches();
	}
}
