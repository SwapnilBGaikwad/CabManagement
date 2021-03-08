package com.phonepe.reader;


import com.phonepe.command.Command;
import com.phonepe.command.ExitCommand;

import java.io.BufferedReader;

public class CommandReader {
    private final BufferedReader reader;
    private final CommandFactory commandFactory;

    public CommandReader(BufferedReader reader, CommandFactory commandFactory) {
        this.reader = reader;
        this.commandFactory = commandFactory;
    }

    public Command readCommand() {
        try {
            final String instruction = reader.readLine();
            return commandFactory.create(instruction);
        } catch (Exception e) {
            return new ExitCommand();
        }
    }
}
