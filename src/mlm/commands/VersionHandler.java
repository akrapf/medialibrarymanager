package mlm.commands;

import mlm.app.Config;
import mlm.command.Command;
import mlm.command.CommandHandler;
import mlm.command.CommandResult;

/**
 * Requests the current application version.
 * @since 0.1
 */
public class VersionHandler implements CommandHandler {

	//TODO rewrite javadoc header to focus on class implementation and general functions
	
	/**
	 * Outputs the current application version as requested from the Configuration file.
	 * @see mlm.app.Config
	 */
	@Override
	public CommandResult execute(Command command) {
		System.out.println("Media Library Manager v" + Config.getVersion());
		System.out.println();
		
		return CommandResult.success();
	}
}
