package com.greenlightdigital.main;

import java.net.URL;

/**
 * @author Vladislav Naydenov
 *
 */
public class Logger {

	public static void main(String[] args) {
		URL resource = Logger.class.getClassLoader().getResource("Logins.txt");
	}
	
	public void readFile() {
		
	}
	
	public String readLine() {
		return null;
	}
}
