package com.mlm.commands;

import com.mlm.command.Command;
import com.mlm.command.CommandHandler;
import com.mlm.command.CommandResult;

/**
 * Echos the user's input.
 * Currently functions as debug, returns parsed command contents.
 * Future update will correct implementation.
 * @since 0.1
 */
public class EchoHandler implements CommandHandler {

	//TODO rewrite javadoc header to focus on class implementation and general functions
	//TODO Refactor debug implementation to seperate argument
	//TODO Implement proper echo function to raw input
	
	/**
	 * Echos the user's input by displaying parsed command.
	 */
	@Override
	public CommandResult execute(Command command) {
	    System.out.println(command);
	    System.out.println();
	    
	    return CommandResult.success();
	}
}