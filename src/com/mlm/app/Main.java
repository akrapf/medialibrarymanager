package com.mlm.app;

import com.mlm.console.Console;
import com.mlm.testing.UnitTest;

public class Main {
	
	// Flag for testing mode. Application exits after queue completion. Manual edit only.
	private static final boolean UNIT_TEST_FLAG = false;
	
	public static void main(String[] args) {
		
		if (UNIT_TEST_FLAG) {
			UnitTest.RunQueue();
		} else {
			Console console = new Console();
			console.start();
		}
	}
}