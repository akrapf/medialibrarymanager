package com.mlm.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mlm.app.Config;
import com.mlm.command.Command;
import com.mlm.command.CommandParser;

/**
 * Handles user input from the console and passes commands to the appropriate command handlers.
 * Commands should delegate operations to service classes.
 */
public class Console {

	private final Scanner consoleInput;
	private final CommandParser commandParser;

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
			
			input = consoleInput.nextLine().trim(); //TODO convert to new Command object, adjust switch case
			
			//Quietly ignores blank inputs rather than pass to command parser
			if (input.isBlank()) {
				continue;
			}
			
			//Record all user input including invalid commands.
			//Behaves as a terminal history rather than record of successful execution.
			//TODO separate into inputHistory (all) and executionHistory (valid commands, pass/fail)
			commandHistory.add(input);
			
			Command command = commandParser.parseCommand(input); //parse input into Command object
			
			//TODO replace Switch with CommandExecutor object
			switch (command.getName()) {
			case "help":
				help();
				break;
			case "version":
				version();
				break;
			case "history":
				history();
				break;
			case "clear":
				clear();
				break;
			case "echo":
				echo(command);
				break;
			case "exit":
				running = shutdown();
				break;
			default:
				//TODO After command parsing, allow error returns on invalid portions
				//eg "Unknown Command 'input'" or "Invalid Arguments for command 'input'"
				//potential addition of expected input; eg "Invalid Arguments...expected [args]"
				System.out.println("Unknown Command: " + command);
				System.out.println();
			}
		}
		
		consoleInput.close();
	}
	
	/**
	 * Outputs available commands to the console.
	 */
	private void help() {
		System.out.println("Available Commands:");
		System.out.printf(" %-12s %s%n", "help", "Display available commands.");
		System.out.printf(" %-12s %s%n", "version", "Display application version.");
		System.out.printf(" %-12s %s%n", "history", "Display command history.");
		System.out.printf(" %-12s %s%n", "clear", "Clear the console.");
		System.out.printf(" %-12s %s%n", "echo", "Echo supplied arguments.");
		System.out.printf(" %-12s %s%n", "exit", "Exit the application.");
		System.out.println();
	}
	
	/**
	 * Outputs the current application version as requested from the Configuration file.
	 * @see com.mlm.app.Config
	 */
	private void version() {
		System.out.println("Media Library Manager v" + Config.getVersion());
		System.out.println();
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
	 * Clears the console screen.
	 * Currently only supported in Windows CMD.
	 */
	private void clear() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Echos the user's input by displaying parsed command.
	 * TODO implement proper echo() to output rawInput
	 */
	private void echo(Command command) {
	    System.out.println(command);
	    System.out.println();
	}
	
	/**
	 * Attempt safe shutdown of application.
	 * Currently only returns false, will modify when adding shutdown tasks
	 * @return false successful shutdown, set running var to false
	 */
	private boolean shutdown() {
		System.out.println("Exiting...");
		//Future program shutdown tasks here		
		return false;
	}
	
	private void printBanner() {
		System.out.println("Media Library Manager v" + Config.getVersion());
		System.out.println("Dev Commands: clear, echo, exit, help, history, version"); //DEBUG - all available commands
		System.out.println();
	}
}