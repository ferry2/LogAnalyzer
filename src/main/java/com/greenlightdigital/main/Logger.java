package com.greenlightdigital.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import com.greenlightdigital.analyzer.impl.LogAnalyzerImpl;
import com.greenlightdigital.analyzer.interfaces.LogAnalyzer;

/**
 * @author Vladislav Naydenov
 *
 */
public class Logger {

	private static LogAnalyzer logAnalyzer = new LogAnalyzerImpl();
	
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
				logAnalyzer.parseLine(currentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		
	}
	
	public String readLine() {
		return null;
	}
}
