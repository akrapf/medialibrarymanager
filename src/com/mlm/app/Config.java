package com.mlm.app;

/**
 * Configuration settings for the application.
 * Includes static application information and user settings.
 */
public final class Config {

	private static final String VERSION = "0.1.0";
	
	private Config() {}
	
	public static String getVersion() {
		return VERSION;
	}
}