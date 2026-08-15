package mlm.command;

/**
 * Interface for Command classes.
 * @see mlm.commands
 */
public interface CommandHandler {
	
	//TODO After command parsing, allow error returns on invalid portions
	//eg "Unknown Command 'input'" or "Invalid Arguments for command 'input'"
	//expected input; eg "Invalid Arguments...expected [args]"

	/**
	 * Executes the Command and returns a CommandResult.
	 * @param command the parsed Command
	 * @return a CommandResult object
	 * @see mlm.command.CommandResult
	 */
	CommandResult execute(Command command);
}