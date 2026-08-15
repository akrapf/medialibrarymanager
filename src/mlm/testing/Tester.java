package mlm.testing;

import java.util.Arrays;

import mlm.command.Command;
import mlm.command.CommandHandler;
import mlm.command.CommandParser;
import mlm.command.CommandResult;

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
	 * Tests CommandParser for input validation, output, argument/flag, quoted arguments.
	 */
	private static void commandParserTest() {
		CommandParser cmdparser = new CommandParser();
		
		String[] commandParseList = {"", " whitespace	tab", "history", "history input", "history --execution", "scan Movies",
				"scan \"D:\\Media Library\\Movies\"", "scan Movies --recursive", "scan --recursive Movies", "report --format html Movies --type mp4"};
		
		String[] invalidParseList = {"", "--recursive", "scan --", "scan --type", "scan --type --recursive"};
		
		System.out.println("Testing argument/flag parsing...");
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
		
		System.out.println("Testing invalid argument/flag parsing...");
		
		for (String input : invalidParseList) {
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