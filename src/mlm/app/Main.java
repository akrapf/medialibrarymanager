package mlm.app;

import mlm.command.Command;
import mlm.command.CommandParser;
import mlm.console.Console;
import mlm.services.HistoryService;

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

		//testParser(); //debug
		
		console.start();
	}
	
	private void testParser() { //debug -- leave for testing parser updates
		System.out.println("testing parser...");
		CommandParser cmdprs = new CommandParser();
		String[] inputs =
			{"scan \"C:\\Movies\" --type=mp4 --verbose=true",
			"scan Movies TV --recursive=true --recursive=false",
			//"scan --=value",
			"scan --value==\"test\"",
			"scan --=",
			//"scan --value=\"",
			"scan --silent \"C:\\Media Library\\Movies\" --recursive --report=\"C:\\Media Library\\scanresults.txt\" --schedule=12:00am test"};
		
		for (String input : inputs) {
			System.out.println("input = " + input);
			Command c = cmdprs.parseCommand(input);
			System.out.println("command = " + c);
		}
	}
}