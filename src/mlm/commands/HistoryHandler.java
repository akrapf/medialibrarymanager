package mlm.commands;

import mlm.command.Command;
import mlm.command.CommandHandler;
import mlm.command.CommandResult;
import mlm.services.HistoryService;

public class HistoryHandler implements CommandHandler {
	//TODO javadoc
	
	/**
	 * Reference pointer to Main
	 */
	private final HistoryService historyService;
	
	public HistoryHandler(HistoryService historyService) {
		this.historyService = historyService;
	}
	
	@Override
	public CommandResult execute(Command command) {		
		
		//TODO implement argument/flag parsing 'history --executed' 'history --input' 'history [default]'
		
		printInputHistory();

		return CommandResult.success();
	}
	
	//in handler - cli, not visible to gui through Service layer
	public void printInputHistory() {
		int number = 1;
		for (String command : historyService.getInputHistory()) {
			System.out.println(number++ + " " + command);
		}
		System.out.println(); //TODO may not be needed since Console returns a new line at the end of its loop
	}
	
	//in handler - cli, not visible to gui through Service layer
	public void printExecutionHistory() {
		int number = 1;
		for (String command : historyService.getExecutionHistory()) {
			System.out.println(number++ + " " + command);
		}
		System.out.println(); //TODO may not be needed since Console returns a new line at the end of its loop
	}
}