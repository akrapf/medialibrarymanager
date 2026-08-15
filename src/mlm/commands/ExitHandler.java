package mlm.commands;

import mlm.command.Command;
import mlm.command.CommandHandler;
import mlm.command.CommandResult;

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