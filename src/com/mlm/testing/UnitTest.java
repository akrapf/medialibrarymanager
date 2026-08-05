package com.mlm.testing;

import java.util.Arrays;

import com.mlm.command.CommandParser;

/**
 * Developer testing workspace.
 * Test logic in methods and executed through Queue.
 */
public class UnitTest {
	
	//TODO refactor into object, call from console w/ args. Allow bypass from Main.
	
	/**
	 * User-edited test queue.
	 */
	private static void Queue() {
		
		CommandParserTest();
	}
	
	/**
	 * Executes user-generated queue for unit tests.
	 * Requires manual adjustment to test flag and executes from Main.
	 */
	public static void RunQueue() {
		System.out.println("EXECUTING UNIT TESTS");
		System.out.println();
		
		Queue();
		
		System.out.println();
		System.out.println("UNIT TEST QUEUE COMPLETED");
	}
	
	/**
	 * Test Command Parser to observe output.
	 * @see com.mlm.command.CommandParser
	 */
	private static void CommandParserTest() {
		CommandParser cmdparser = new CommandParser();		
		
		String[] commandParseList = {"", " ", "help", "version", "Hello World", "command arg1 arg2 arg3", "scan help", "scan library Movies", "scan D:\\media\\movies", "scam D\\TV Shows\\", " lead and trail whtspc    "};
		
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
