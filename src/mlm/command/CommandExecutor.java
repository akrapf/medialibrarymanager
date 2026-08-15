package mlm.command;

import java.util.HashMap;
import java.util.Map;

import mlm.commands.ClearHandler;
import mlm.commands.EchoHandler;
import mlm.commands.ExitHandler;
import mlm.commands.HelpHandler;
import mlm.commands.HistoryHandler;
import mlm.commands.VersionHandler;
import mlm.services.HistoryService;
import mlm.testing.Tester;

/**
 * Routes Commands to the correct command implementation.
 * Does not directly execute commands.
 */
public class CommandExecutor {

	//Registry map for top level commands
	private final Map<String, CommandHandler> handlers;
	
	/**
	 * Constructor for the executor; creates HashMap registry of all commands.
	 * @see mlm.command.CommandHandler
	 */
	public CommandExecutor(HistoryService historyService) {
		
		this.handlers = new HashMap<>();
		
		//Add top level commadnds to the handlers HashMap
		//TODO automate addition
		handlers.put("clear", new ClearHandler());
		handlers.put("echo", new EchoHandler());
		handlers.put("exit", new ExitHandler()); //TODO test in console
		handlers.put("help", new HelpHandler());
		handlers.put("history", new HistoryHandler(historyService));
		handlers.put("version", new VersionHandler());
		handlers.put("dev", new Tester()); //DEBUG
	}
	
	/**
	 * Find the command in the HasMap registry and send to it's handler.
	 * @param command the parsed Command to be executed
	 * @return CommandResult status
	 * @see mlm.command.Command
	 * @see mlm.command.CommandResult
	 */
	public CommandResult execute(Command command) {
		CommandHandler handler = handlers.get(command.getName());
		
		if (handler == null) {
			System.out.println("Unknown Command: " + command.getName());
			return CommandResult.failure();
		}
		
		return handler.execute(command);
	}
}