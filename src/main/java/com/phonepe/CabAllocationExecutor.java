package com.phonepe;


import com.phonepe.command.Command;
import com.phonepe.command.ExitCommand;
import com.phonepe.reader.CommandReader;

public class CabAllocationExecutor {
    private final CommandReader reader;

    public CabAllocationExecutor(CommandReader commandReader) {
        this.reader = commandReader;
    }

    public void execute() {
        while (true) {
            final Command command = reader.readCommand();
            if (command instanceof ExitCommand) {
                return;
            }
            System.out.println(command.execute());
        }
    }
}
