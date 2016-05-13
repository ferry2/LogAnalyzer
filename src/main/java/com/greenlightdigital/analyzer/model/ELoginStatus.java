package com.greenlightdigital.analyzer.model;

public enum ELoginStatus {
	SUCCESS,
	FAILURE,
	UNKNOWN;
	
	public static ELoginStatus of(String internalReference) {
		try {
			return ELoginStatus.valueOf(internalReference);
		} catch (Exception e) {
			return UNKNOWN;
		}
	}
}
