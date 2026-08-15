package mlm.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Provides parsing for inputs to create Command objects.
 * Provides syntax validation; argument-level validation occurs at Handler or Service level.
 */
public class CommandParser {
	
	/**
	 * Parses passed input into command root with attached arguments and flags.
	 * Valid syntax: command [args...] [--flag] [--flag=value]
	 * Flag values with whitespace require quotation.
	 * Duplicate flags will use last-in values.
	 * WARNING: Missing '=' in flag will parse value as an argument. Fix planned in command registry.
	 * @param input the raw String user input
	 * @return a Command object
	 * @see mlm.command.Command
	 */
	public Command parseCommand(String input) {		

		//TODO fix missed = in flag w/ command registry
		//TODO potentially catch invalid flag syntax "-, ---"
		
		if (input.isBlank()) {
			throw new IllegalArgumentException("Command input cannot be blank.");
		}
		
		List<String> tokens = tokenize(input);
		String name = tokens.get(0); //first token is always command name
		List<String> arguments = new ArrayList<>();
		Map<String, String> flags = new HashMap<>();
		
		for (int i = 1; i < tokens.size(); i++) { //iterate token list. if only one token, loop skips
			String token = tokens.get(i);
			
			//if the token is not a flag, add to arguments
			if (!token.startsWith("--")) {
				arguments.add(token);
				continue;
			}
			
			//if not an argument, must be a flag
			String flagName;
			String flagValue;
			int equalsIndex = token.indexOf("="); //return -1 if not included
			
			if (equalsIndex >= 0) { //if flag "=" was found
				flagName = token.substring(2, equalsIndex); //substring between "--" and "="
				flagValue = token.substring(equalsIndex + 1); //substring from "=" to token end
			} else {
				flagName = token.substring(2); //substring from "--" to token end
				flagValue = null; //no flag value provided
			}
			
			if (flagName.isBlank()) {
				throw new IllegalArgumentException("Flag name cannot be blank.");
			}
			
			flags.put(flagName, flagValue);
		}
		
		return new Command(name, arguments, flags);
	}
	
	/**
	 * Tokenizes String input into a List and validates input formatting.
	 * Strips whitespace and acknowledges quoted arguments.
	 * @param input raw user input String
	 * @return List<String> of input tokens
	 */
	public List<String> tokenize(String input) {
		boolean insideQuotes = false;		
		boolean tokenStarted = false;
		char[] inputChars = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		ArrayList<String> tokens = new ArrayList<String>();
		
		for (char c : inputChars) {	
			//check if next char is quoted and flip boolean
			if (c == '"') {
				insideQuotes = !insideQuotes;
				tokenStarted = true;
				continue;
			}
			
			//if next char is whitespace and not quoted, terminate the token
			if (Character.isWhitespace(c) && !insideQuotes) {
				if (tokenStarted) {
					tokens.add(sb.toString());
					sb.setLength(0);
					tokenStarted = false;
				}
			} else { //if next char is not whitespace, continue building token
				sb.append(c);
				tokenStarted = true;
			}
		}
		
		//if a token has been started, terminate after loop ends
		if (tokenStarted) {
			tokens.add(sb.toString());
		}

		//if tokenizer never found trailing quotes, throw an exception
		if (insideQuotes) {
			throw new IllegalArgumentException("Unterminated quoted argument.");
		}
		
		return tokens;
	}
}