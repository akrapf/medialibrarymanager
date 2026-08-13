package com.mlm.app;

/**
 * Configuration settings for the application.
 * Utility class - includes static application information and user settings.
 */
public final class Config {

	private static final String VERSION = "0.2.0";
	
	private Config() {} //private constructor to prevent creation of Config object
	
	public static String getVersion() {
		return VERSION;
	}
}