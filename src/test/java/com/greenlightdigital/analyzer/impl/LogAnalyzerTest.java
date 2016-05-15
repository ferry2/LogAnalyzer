package com.greenlightdigital.analyzer.impl;

import java.util.Date;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.greenlightdigital.analyzer.interfaces.LogAnalyzer;
import com.greenlightdigital.analyzer.model.ELoginStatus;
import com.greenlightdigital.analyzer.model.LogEntry;

public class LogAnalyzerTest {

	private LogAnalyzer cut = new LogAnalyzerImpl();
	
	@Test
	public void testParseLine() {
		LogEntry expected = new LogEntry("30.212.19.124", new Date(1462457652L), ELoginStatus.FAILURE, "Thomas.Davenport");
		LogEntry actual = cut.parseLine("30.212.19.124,1462457652,FAILURE,Thomas.Davenport");
		
		Assert.assertThat(actual, CoreMatchers.is(expected));
	}
}
