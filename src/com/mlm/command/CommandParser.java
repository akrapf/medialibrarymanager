package com.mlm.command;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Provides parsing for inputs to create Command objects.
 * Argument validation and sanitization happens at Command level and not during parsing.
 */
public class CommandParser {
	
	/**
	 * Parses passed input into command root and attached arguments.
	 * @param input the raw String user input
	 * @return a Command object
	 * @see com.mlm.command.Command
	 */
	public Command parseCommand(String input) {		
		//TODO quoted argument support
		
		//If passed input contains nothing or only whitespace, return a null command.
		//Included separate from Console integration to future-proof GUI support
		if (input.isBlank()) {
			throw new IllegalArgumentException("Command input cannot be blank.");
		}
		
		String[] parts = input.trim().split("\\s+"); //split on one or more whitespace characters
		ArrayList<String> arguments = new ArrayList<String>(Arrays.asList(parts)); //convert input into ArrayList
		String name = arguments.remove(0); //returns and removes the command from the ArrayList
		
		return new Command(name, arguments);
	}
}