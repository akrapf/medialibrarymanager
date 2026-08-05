package com.mlm.command;

import java.util.HashMap;
import java.util.Map;

import com.mlm.commands.*;
import com.mlm.testing.UnitTest;

/**
 * Routes Commands to the correct command implementation.
 * Does not directly execute commands.
 */
public class CommandExecutor {

	//Registry map for top level commands
	private final Map<String, CommandHandler> handlers;
	
	/**
	 * Constructor for the executor; creates HashMap registry of all commands.
	 * @see com.mlm.command.CommandHandler
	 */
	public CommandExecutor() {
		handlers = new HashMap<>();
		
		//Add top level commadnds to the handlers HashMap
		//TODO automate addition
		handlers.put("clear", new ClearHandler());
		handlers.put("echo", new EchoHandler());
		handlers.put("exit", new ExitHandler()); //TODO test in console
		handlers.put("help", new HelpHandler());
		//handlers.put("history", new HistoryCommand());
		handlers.put("version", new VerisonHandler());
		//handles.put("unittest, new UnitTest()); //debug
	}
	
	/**
	 * Find the command in the HasMap registry and send to it's handler.
	 * @param command the parsed Command to be executed
	 * @return CommandResult status
	 * @see com.mlm.command.Command
	 * @see com.mlm.command.CommandResult
	 */
	public CommandResult execute(Command command) {
		CommandHandler handler = handlers.get(command.getName());
		
		if (handler == null) {
			System.out.println("CE Unknown Command: " + command.getName()); //debug 'ce'
			return CommandResult.failure();
		}
		
		return handler.execute(command);
	}
}