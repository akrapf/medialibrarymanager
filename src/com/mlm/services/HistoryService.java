package com.mlm.services;

import java.util.ArrayList;
import java.util.List;

public class HistoryService {

	//TODO javadoc
	//TODO first argument implementation
		// how to call methods based on arguments? hashmap? avoid switch statements, search by argument.
		// argument validation
		// verbose error / output helper class / logging infrastructure?
	//TODO possible to shorten codebase w/out methods for each history List<>?
	//TODO history if input Strings or history of Command objects?
		// object can contain name, args, result, timestamp, etc...
		// vs committing memory when currently freed in Console after execution?
	
	private final List<String> inputHistory;
	private final List<String> executionHistory;
	
	public HistoryService() {
		inputHistory = new ArrayList<>();
		executionHistory = new ArrayList<>();
	}
	
	public void recordInput(String input) {
		inputHistory.add(input);
	}
	
	public void recordExecution(String input) {
		executionHistory.add(input);
	}
	
	public List<String> getInputHistory() {
		return inputHistory;
	}
	
	public List<String> getExecutionHistory() {
		return executionHistory;
	}
	
	public void clearInput() {
		inputHistory.clear();
	}
	
	public void clearExecution() {
		executionHistory.clear();
	}
	
	public int inputSize() {
		return inputHistory.size();
	}
	
	public int executionSize() {
		return executionHistory.size();
	}
	
	public void search(String input) {
		//TODO returns...indexes, command ovjects? need new storage structure
	}
	
	/** TODO - why better than using getHistory().get(index)?
	 * getprevious
	 * getnext
	 */
}