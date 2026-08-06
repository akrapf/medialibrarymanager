package com.mlm.command;

/**
 * Interface for Command classes.
 * @see com.mlm.commands
 */
public interface CommandHandler {

	/**
	 * Executes the Command and returns a CommandResult.
	 * @param command the parsed Command
	 * @return a CommandResult object
	 * @see com.mlm.command.CommandResult
	 */
	CommandResult execute(Command command);
}