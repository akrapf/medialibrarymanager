package com.mlm.testing;

import java.util.Arrays;

import com.mlm.command.Command;
import com.mlm.command.CommandHandler;
import com.mlm.command.CommandParser;
import com.mlm.command.CommandResult;

/**
 * Developer testing workspace.
 * Test logic in methods and executed through Queue.
 * Operates similar to Handler classes, contained independently in Tester object.
 */
public class Tester implements CommandHandler {
	
	/**
	 * Executes the manually created queue().
	 * Will eventually parse arguments to specify specific test methods.
	 */
	@Override
	public CommandResult execute(Command command) {

		try {
			executeQueue();
		} catch (Exception e) {
			System.out.println("ERROR > TESTING QUEUE EXECUTION");
			e.printStackTrace();
			return CommandResult.failure();
		}
		
		return CommandResult.success();
	}
	
	/**
	 * Executes user-generated queue for unit tests.
	 */
	public void executeQueue() {
		System.out.println("EXECUTING MANUAL TEST QUEUE");
		System.out.println();
		
		queue();
		
		System.out.println();
		System.out.println("MANUAL TEST QUEUE COMPLETED");
	}

	/**
	 * Manually user-edited test queue.
	 * May eventually allow CLI queuing.
	 */
	private static void queue() {
		
		commandParserTest();
	}
	
	/**
	 * Test Command Parser to observe output.
	 * @see com.mlm.command.CommandParser
	 */
	private static void commandParserTest() {
		CommandParser cmdparser = new CommandParser();		
		
		String[] commandParseList = {"", " ", "help", "version", "Hello World", "command arg1 arg2 arg3", "help scan", "scan library Movies", "scan D:\\media\\movies", "scam D\\TV Shows\\", " lead and trail whtspc    "};
		
		System.out.println("Testing CommandParser...");
		
		System.out.println("Testing List: " + Arrays.toString(commandParseList));
		
		for (String input : commandParseList) {
		    System.out.println("Parsing Command: '" + input + "'");
		    try {
		        System.out.println("Generated Command: " + cmdparser.parseCommand(input));
		    } catch (IllegalArgumentException e) {
		        System.out.println("Parser Exception: " + e.getMessage());
		    }
		    System.out.println();
		}
		
		System.out.println("Completed CommandParser Test");
	}
}