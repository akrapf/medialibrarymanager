package mlm.commands;

import java.io.IOException;

import mlm.command.Command;
import mlm.command.CommandHandler;
import mlm.command.CommandResult;

/**
 * Clears the console.
 * Currently only supported on Windows CMD.
 * @since 0.1
 */
public class ClearHandler implements CommandHandler {

	//TODO rewrite javadoc header to focus on class implementation and general functions
	//TODO BUG - running clear in cmd can produce blocks of empty space after previous output
	
	/**
	 * Clears the Windows cmd console.
	 */
	@Override
	public CommandResult execute(Command command) {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start();
		} catch (IOException e) {
			return CommandResult.failure();
		}
		return CommandResult.success();
	}
}