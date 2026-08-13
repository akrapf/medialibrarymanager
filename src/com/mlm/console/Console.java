package com.mlm.console;

import java.util.Scanner;

import com.mlm.app.Config;
import com.mlm.command.Command;
import com.mlm.command.CommandExecutor;
import com.mlm.command.CommandParser;
import com.mlm.command.CommandResult;
import com.mlm.services.HistoryService;

/**
 * Handles user input from the console and passes commands to the appropriate command handlers.
 * Commands should delegate operations to service classes.
 */
public class Console {
	
	private final Scanner consoleInput;
	private final CommandParser commandParser;
	private final CommandExecutor commandExecutor;
	
	/**
	 * Reference pointers to Main
	 */
	private final HistoryService historyService;
	
	/**
	 * Self-contained Console object; allows for multiple Consoles to exist.
	 * Holds individual input scanners, command parsers, and command histories.
	 * In future may add security limitations to these objects.
	 * @param historyService
	 */
	public Console(HistoryService historyService) {
		this.historyService = historyService;
		
		this.consoleInput = new Scanner(System.in);
		this.commandParser = new CommandParser();		
		this.commandExecutor  = new CommandExecutor(historyService);
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
			historyService.recordInput(input);
			
			Command parsedCommand = commandParser.parseCommand(input); //parse input into Command object
			
			CommandResult result = commandExecutor.execute(parsedCommand);
			
			//Record only executed commands.
			//TODO output with commandresult
			//TODO history object in list, contains Command, timestamp, results, etc
			historyService.recordExecution(input);
			
			if (result.shouldShutdown()) {
				running = false;
			}
			
			System.out.println();
		}
		
		consoleInput.close();
	}
	
	/**
	 * Prints the console banner upon console startup.
	 */
	private void printBanner() {
		//TODO ascii banner, formatting, random welcome message
		System.out.println("Media Library Manager v" + Config.getVersion());
		System.out.println("Dev Commands: dev []"); //debug
		System.out.println("CLI Commands: clear, echo, exit, help, history, version"); //debug
		System.out.println();
	}
}