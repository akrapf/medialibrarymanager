package com.mlm.app;

import com.mlm.console.Console;
import com.mlm.testing.Tester;

public class Main {
	
	/**
	 * Flag for testing mode. Application exits after queue completion. Manual edit only.
	 * Bypasses Console for unit test execution for Console debugging.
	 * Normal execution through Console `dev [args]`
	 * TODO remove when dev command implemented
	 */
	private static final boolean UNIT_TEST_FLAG = false; //debug
	
	public static void main(String[] args) {
		if (UNIT_TEST_FLAG) {
			Tester.runQueue();
		} else {
			Console console = new Console();
			console.start();
		}
	}
}