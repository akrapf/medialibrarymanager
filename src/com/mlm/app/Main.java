package com.mlm.app;

import com.mlm.console.Console;
import com.mlm.services.HistoryService;

public class Main {
	
	public static void main(String[] args) {
		
		//TODO iterate through List<> of all Services to init and pass List<> to Console
		//TODO future try/catch for Service startup
		//if Service init fails, block commands/GUI actions related to that service
		//display verbose error (HistoryService failed startup...); logging
		
		/**
		 * Services created in Main, passed to Console constructor.
		 * Must be reachable by both CLI and GUI.
		 */
		HistoryService historyService = new HistoryService();

		Console console = new Console(historyService);
		console.start();
	}
}