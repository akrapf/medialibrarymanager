package com.mlm.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mlm.app.Config;
import com.mlm.command.Command;
import com.mlm.command.CommandExecutor;
import com.mlm.command.CommandParser;
import com.mlm.command.CommandResult;

/**
 * Handles user input from the console and passes commands to the appropriate command handlers.
 * Commands should delegate operations to service classes.
 */
public class Console {
	
	private final Scanner consoleInput;
	private final CommandParser commandParser;
	private final CommandExecutor commandExecutor;
	
	//Stores all user input as Strings.
	private final List<String> commandHistory;
	
	/**
	 * Self-contained Console object; allows for multiple Consoles to exist.
	 * Holds individual input scanners, command parsers, and command histories.
	 * In future may add security limitations to these objects.
	 */
	public Console() {
		consoleInput = new Scanner(System.in);
		commandParser = new CommandParser();
		commandExecutor = new CommandExecutor();
		commandHistory = new ArrayList<>();
	}
	
	/**
	 * Starts the console and requests user input.
	 * User input is parsed and returned as a Command object,
	 * then passed through the Executor to perform the Command.
	 * @see com.mlm.command.Command
	 * @see com.mlm.command.CommandParser
	 * @see com.mlm.command.CommandExecutor
	 */
	public void start() {
		String input = "";
		boolean running = true;
		
		printBanner();
		
		while (running) {
			System.out.print("> ");
			
			input = consoleInput.nextLine().trim();
			
			//Quietly ignores blank inputs rather than pass to command parser
			if (input.isBlank()) {
				continue;
			}
			
			//Record all user input including invalid commands.
			//Behaves as a terminal history rather than record of successful execution.
			//TODO separate into inputHistory (all) and executionHistory (valid commands, pass/fail)
			commandHistory.add(input);
			
			Command parsedCommand = commandParser.parseCommand(input); //parse input into Command object

			CommandResult result = commandExecutor.execute(parsedCommand);
			
			if (result.shouldShutdown()) {
				running = false;
			}
			
			//TODO finish replacing switch statement through CommandExecutor
			//final command will move with HistoryService implementation in v0.2
			//TODO replace switch default with command argument validation in CommandParser and Handlers
			
			switch (parsedCommand.getName()) {
			case "history":
				history();
				break;
			default:
				//TODO After command parsing, allow error returns on invalid portions
				//eg "Unknown Command 'input'" or "Invalid Arguments for command 'input'"
				//expected input; eg "Invalid Arguments...expected [args]"
				System.out.println("C Unknown Command: " + parsedCommand); //debug 'c'
				System.out.println();
			}
		}
		
		consoleInput.close();
	}
	
	/**
	 * Outputs the users input history.
	 * TODO input and command execution history separated
	 */
	private void history() {
		int number = 1;
		for (String command : commandHistory) {
			System.out.println(number++ + " " + command);
		}
		System.out.println();
	}
	
	/**
	 * Prints the console banner upon console startup.
	 */
	private void printBanner() {
		//TODO ascii banner, formatting, random welcome message
		System.out.println("Media Library Manager v" + Config.getVersion());
		System.out.println("Dev Commands: dev [ut]"); //debug
		System.out.println("CLI Commands: clear, echo, exit, help, history, version"); //debug
		System.out.println();
	}
}