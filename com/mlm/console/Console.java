package com.mlm.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mlm.app.Config;
import com.mlm.command.Command;

/**
 * Handles user input from the console and passes commands
 * to the appropriate command handlers.
 * Commands should delegate operations to service classes.
 */
public class Console {

	private final Scanner consoleInput;

	//Stores all user input as Strings.
	private final List<String> commandHistory;
	
	public Console() {
		consoleInput = new Scanner(System.in);
		commandHistory = new ArrayList<>();
	}
	
	public void start() {

		String input = "";
		boolean running = true;
		
		printBanner();
		
		while (running) {
			System.out.print("> ");
			
			input = consoleInput.nextLine().trim(); //TODO convert to new Command object, adjust switch case
			
			//Record all user input including invalid commands.
			//Behaves as a terminal history rather than record of successful execution.
			if (input.isBlank()) {
				continue;
			}
			commandHistory.add(input);
			
			switch (input) {
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
				//echo();
				break;
			case "exit":
				running = shutdown();
				break;
			default:
				System.out.println("Unknown Command\n");
			}
		}
		
		consoleInput.close();
	}
	
	private void help() {
		System.out.println("Available Commands:");
		System.out.println(" help > display commands");
		System.out.println(" version > display current application version");
		System.out.println(" history > display historical commands executed");
		System.out.println(" clear > clear terminal output (windows cmd only)");
		System.out.println(" echo > output last input commands");
		System.out.println(" exit > quit application");
		System.out.println();
	}
	
	private void version() {
		System.out.println("Media Library Manager v" + Config.getVersion());
		System.out.println();
	}
	
	private void history() {
		int number = 1;
		for (String command : commandHistory) {
			System.out.println(number++ + " " + command);
		}
		System.out.println();
	}
	
	//Clears console screen (Windows cmd)
	private void clear() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void echo(Command command) {

	    for(String argument : command.getArguments()) {
	        System.out.print(argument + " ");
	    }
	    System.out.println();
	}
	
	private boolean shutdown() {
		System.out.println("Exiting...");
		//Future program shutdown tasks here		
		return false;
	}
	
	private void printBanner() {
		System.out.println("Media Library Manager v" + Config.getVersion());
		System.out.println("Dev Commands: clear, echo (wip), exit, help, history, version"); //DEBUG - all available commands
		System.out.println();
	}
}