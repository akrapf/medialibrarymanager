package com.mlm.app;

public final class Config {

	private static final String VERSION = "0.1.0";
	
	private Config() {}
	
	public static String getVersion() {
		return VERSION;
	}
}