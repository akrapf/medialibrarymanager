package com.mlm.command;

import java.util.List;

/**
 * Command object constructor. Should only ever be created by passing through CommandParser.
 * In future will hold all Command specific data (time stamps, pass/fail, etc)
 */
public class Command {

	//TODO add flags
    private final String name;
    private final List<String> arguments;

    /**
     * Command constructor. Should only be called from CommandParser.
     * 
     * @param name command name
     * @param arguments command arguments
     * @see com.mlm.command.CommandParser
     */
    public Command(String name, List<String> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public List<String> getArguments() {
        return arguments;
    }
    
    /**
     * Returns String representation of Command object.
     * @return a String representation of Command object as {command, args[]}
     */
    @Override
    public String toString() {
        return "Command{name='" + name + "', arguments=" + arguments + "}";
    }
}