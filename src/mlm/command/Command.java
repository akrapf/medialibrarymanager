package mlm.command;

import java.util.List;
import java.util.Map;

/**
 * Command object. Should only ever be created by passing through CommandParser.
 */
public class Command {

    private final String name;
    private final List<String> arguments;
    private final Map<String, String> flags; //Mao<String, Optional<String>>

    /**
     * Command constructor. Should only be called from CommandParser.
     * 
     * @param name command name
     * @param arguments command arguments
     * @see mlm.command.CommandParser
     */
    public Command(String name, List<String> arguments, Map<String, String> flags) {
        this.name = name;
        this.arguments = arguments;
        this.flags = flags;
    }

    public String getName() {
        return name;
    }

    public List<String> getArguments() {
        return arguments;
    }
    
    public Map<String, String> getFlags() {
    	return flags;
    }
    
    /**
     * Checks if the Command contains arguments by checking if the List is empty.
     * @return boolean
     */
    public boolean hasArguments() {
    	return !arguments.isEmpty();
    }
    
    /**
     * Checks if the Command contains flags by checking if the Map is empty.
     * @return boolean
     */
    public boolean hasFlags() {
    	return !flags.isEmpty();
    }
    
    /**
     * Returns String representation of Command object.
     * @return a String representation of Command object as {command, args[]}
     */
    @Override
    public String toString() {
        return "Command{name='" + name + "', arguments=" + arguments + ", flags=" + flags + "}";
    }
}