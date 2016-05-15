package com.greenlightdigital.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

import com.greenlightdigital.analyzer.impl.IntrusionDetectorImpl;
import com.greenlightdigital.analyzer.impl.LogAnalyzerImpl;
import com.greenlightdigital.analyzer.interfaces.IntrusionDetector;
import com.greenlightdigital.analyzer.interfaces.LogAnalyzer;
import com.greenlightdigital.analyzer.model.LogEntry;

/**
 * @author Vladislav Naydenov
 *
 */
public class Logger {

	private static LogAnalyzer logAnalyzer = new LogAnalyzerImpl();
	private static IntrusionDetector intrusionDetector = new IntrusionDetectorImpl();
	
	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File(Logger.class.getClassLoader().getResource("Logins.txt").toURI())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		String currentLine = null;
		try {
			while((currentLine = reader.readLine()) != null) {
				LogEntry logEntry = logAnalyzer.parseLine(currentLine);
				
				if (!logEntry.isSuccessful()) {
					intrusionDetector.addFailedLogin(logEntry);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
