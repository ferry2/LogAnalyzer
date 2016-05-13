package com.greenlightdigital.validator;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class LogEntryCheckerTest {

	@Test
	public void testIsValidIpAddressWithCorrectInput() {
		Assert.assertThat(LogEntryChecker.isValidIpAddress("30.212.19.124"), is(true));
	}
	
	@Test
	public void testIsValidIpAddressWithWrongInput() {
		Assert.assertThat(LogEntryChecker.isValidIpAddress("blabla"), is(false));
	}
}
