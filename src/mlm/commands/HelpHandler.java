package mlm.commands;

import mlm.command.Command;
import mlm.command.CommandHandler;
import mlm.command.CommandResult;

/**
 * Displays help resources for Console and Command reference.
 * @see /MediaLibraryManager/docs/Command Reference.md
 * @since 0.1
 */
public class HelpHandler implements CommandHandler {

	//TODO rewrite javadoc header to focus on class implementation and general functions
	//TODO verify javadoc (github) style for command reference file
	//TODO implement arguments to display help on specific commands ('help scan')	
	
	/**
	 * Outputs the available top level commands.
	 */
	@Override
	public CommandResult  execute(Command command) {
		System.out.println("Available Commands:");
		System.out.printf(" %-12s %s%n", "help", "Display available commands.");
		System.out.printf(" %-12s %s%n", "version", "Display application version.");
		System.out.printf(" %-12s %s%n", "history", "Display command history.");
		System.out.printf(" %-12s %s%n", "clear", "Clear the console.");
		System.out.printf(" %-12s %s%n", "echo", "Echo supplied arguments.");
		System.out.printf(" %-12s %s%n", "exit", "Exit the application.");
		System.out.println();
		
		return CommandResult.success();
	}
}