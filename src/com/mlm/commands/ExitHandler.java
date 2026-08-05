package com.mlm.commands;

import com.mlm.command.Command;
import com.mlm.command.CommandHandler;
import com.mlm.command.CommandResult;

/**
 * Attempt safe shutdown of application.
 * Currently only returns false, will modify when adding shutdown tasks
 * @since 0.1
 */
public class ExitHandler implements CommandHandler {

	//TODO rewrite javadoc header to focus on class implementation and general functions
	
	/**
	 * Attempt safe shutdown of application.
	 * Currently only returns false, will modify when adding shutdown tasks
	 */
	@Override
	public CommandResult execute(Command command) {
		System.out.println("Exiting...");
		
		//Future program shutdown tasks here
		
		return CommandResult.shutdown();
	}
}